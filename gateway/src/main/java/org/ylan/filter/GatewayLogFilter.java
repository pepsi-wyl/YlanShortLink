package org.ylan.filter;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson2.JSON;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.reactivestreams.Publisher;
import org.slf4j.MDC;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.rewrite.CachedBodyOutputMessage;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.BodyInserterContext;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerStrategies;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import org.ylan.model.entity.GatewayLogDO;
import org.ylan.service.GatewayLogService;
import org.ylan.utils.NetUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.ylan.common.constant.GateWayFilerOrderConstant.GATEWAY_LOG_FILTER_ORDER;
import static org.ylan.common.constant.LogsConstant.TRACE_ID;

/**
 * Gateway日志过滤器
 *
 * @author ylan
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class GatewayLogFilter implements GlobalFilter, Ordered {

    /**
     * 网关日志接口层
     */
    private final GatewayLogService gatewayLogService;

    private static final List<HttpMessageReader<?>> messageReaders = HandlerStrategies.withDefaults().messageReaders();

    @Override
    public int getOrder() {
        return GATEWAY_LOG_FILTER_ORDER;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return buildGatewayLog(exchange, chain);
    }

    /**
     * 构建gateway日志数据
     */
    private Mono<Void> buildGatewayLog(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求信息
        ServerHttpRequest request = exchange.getRequest();
        // 路由信息
        Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);

        // 日志实体
        GatewayLogDO gatewayLog = new GatewayLogDO();
        // 链路追踪ID
        String traceId = MDC.get(TRACE_ID);
        gatewayLog.setTraceId(traceId);
        // 请求ip
        String ip = NetUtils.getActualIp(request);
        gatewayLog.setIp(ip);
        // 请求协议
        String schema = request.getURI().getScheme();
        gatewayLog.setSchema(schema);
        // 请求方法
        String requestMethod = request.getMethod().toString();
        gatewayLog.setRequestMethod(requestMethod);
        // 请求路径
        String requestPath = request.getPath().pathWithinApplication().value();
        gatewayLog.setRequestPath(requestPath);
        // 请求数据类型
        String requestContentType = null;
        MediaType mediaType = request.getHeaders().getContentType();
        if (!Objects.isNull(mediaType)) {
            requestContentType = mediaType.toString();
        }
        gatewayLog.setRequestContentType(requestContentType);
        // 请求时间
        Date requestTime = new Date();
        gatewayLog.setRequestTime(requestTime);
        // 访问实例
        String targetServer = route.getId();
        gatewayLog.setTargetServer(targetServer);
        // 路由配置
        String routeConfig = JSON.toJSONString(route);
        gatewayLog.setRouteConfig(routeConfig);

        if (MediaType.APPLICATION_FORM_URLENCODED.isCompatibleWith(mediaType) || MediaType.APPLICATION_JSON.isCompatibleWith(mediaType)) {
            return writeBodyLog(exchange, chain, gatewayLog);
        } else {
            return writeBasicLog(exchange, chain, gatewayLog);
        }
    }

    /**
     * writeBodyLog
     * 解决 request body 只能读取一次问题，参考: org.springframework.cloud.gateway.filter.factory.rewrite.ModifyRequestBodyGatewayFilterFactory
     */
    @SuppressWarnings("all")
    private Mono<Void> writeBodyLog(ServerWebExchange exchange, GatewayFilterChain chain, GatewayLogDO gatewayLog) {
        ServerRequest serverRequest = ServerRequest.create(exchange, messageReaders);

        Mono<String> modifiedBody = serverRequest.bodyToMono(String.class)
                .flatMap(body -> {
                    // 请求体
                    String requestBody = body;
                    gatewayLog.setRequestBody(requestBody);
                    return Mono.just(body);
                });

        // 通过 BodyInserter 插入 body(支持修改body), 避免 request body 只能获取一次
        BodyInserter bodyInserter = BodyInserters.fromPublisher(modifiedBody, String.class);
        HttpHeaders headers = new HttpHeaders();
        headers.putAll(exchange.getRequest().getHeaders());
        headers.remove(HttpHeaders.CONTENT_LENGTH);

        CachedBodyOutputMessage outputMessage = new CachedBodyOutputMessage(exchange, headers);

        return bodyInserter.insert(outputMessage, new BodyInserterContext())
                .then(Mono.defer(() -> {
                    // 重新封装请求
                    ServerHttpRequest decoratedRequest = requestDecorate(exchange, headers, outputMessage);
                    // 记录响应日志
                    ServerHttpResponseDecorator decoratedResponse = recordResponseLog(exchange, gatewayLog);
                    // 执行过滤器
                    return chain.filter(
                                    exchange.mutate()
                                            .request(decoratedRequest)
                                            .response(decoratedResponse)
                                            .build()
                            )
                            .then(Mono.fromRunnable(() -> {
                                writeAccessLog(gatewayLog);
                            }));
                }));
    }

    /**
     * writeBasicLog
     */
    @SuppressWarnings("all")
    private Mono<Void> writeBasicLog(ServerWebExchange exchange, GatewayFilterChain chain, GatewayLogDO accessLog) {
        // 请求体
        StringBuilder builder = new StringBuilder();
        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        for (Map.Entry<String, List<String>> entry : queryParams.entrySet()) {
            builder.append(entry.getKey()).append("=").append(StringUtils.join(entry.getValue(), ","));
            builder.append("&");
        }
        String requestBody = builder.toString();
        accessLog.setRequestBody(requestBody);

        // 记录响应日志
        ServerHttpResponseDecorator decoratedResponse = recordResponseLog(exchange, accessLog);

        // 执行过滤器
        return chain.filter(
                        exchange.mutate()
                                .response(decoratedResponse)
                                .build()
                )
                .then(Mono.fromRunnable(() -> {
                    writeAccessLog(accessLog);
                }));
    }

    /**
     * 请求装饰器，重新计算 headers
     */
    private ServerHttpRequestDecorator requestDecorate(ServerWebExchange exchange, HttpHeaders headers, CachedBodyOutputMessage outputMessage) {
        return new ServerHttpRequestDecorator(exchange.getRequest()) {
            @Override
            public HttpHeaders getHeaders() {
                long contentLength = headers.getContentLength();
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.putAll(super.getHeaders());
                if (contentLength > 0) {
                    httpHeaders.setContentLength(contentLength);
                } else {
                    httpHeaders.set(HttpHeaders.TRANSFER_ENCODING, "chunked");
                }
                return httpHeaders;
            }

            @Override
            public Flux<DataBuffer> getBody() {
                return outputMessage.getBody();
            }
        };
    }

    /**
     * 记录响应日志，通过 DataBufferFactory 解决响应体分段传输问题
     */
    private ServerHttpResponseDecorator recordResponseLog(ServerWebExchange exchange, GatewayLogDO gatewayLog) {

        ServerHttpResponse response = exchange.getResponse();
        DataBufferFactory bufferFactory = response.bufferFactory();

        return new ServerHttpResponseDecorator(response) {
            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                if (body instanceof Flux) {

                    // 响应时间
                    Date responseTime = new Date();
                    gatewayLog.setResponseTime(responseTime);

                    // 执行时间
                    long executeTime = (gatewayLog.getResponseTime().getTime() - gatewayLog.getRequestTime().getTime());
                    gatewayLog.setExecuteTime(executeTime);

                    // 获取响应类型，如果是 json 就打印
                    String originalResponseContentType = exchange.getAttribute(ServerWebExchangeUtils.ORIGINAL_RESPONSE_CONTENT_TYPE_ATTR);
                    if (ObjectUtil.equal(this.getStatusCode(), HttpStatus.OK)
                            && StringUtils.isNotBlank(originalResponseContentType)
                            && originalResponseContentType.contains("application/json")) {

                        Flux<? extends DataBuffer> fluxBody = Flux.from(body);
                        return super.writeWith(fluxBody.buffer().map(dataBuffers -> {

                            // 合并多个流集合，解决返回体分段传输
                            DataBufferFactory dataBufferFactory = new DefaultDataBufferFactory();
                            DataBuffer join = dataBufferFactory.join(dataBuffers);
                            byte[] content = new byte[join.readableByteCount()];
                            join.read(content);
                            // 释放掉内存
                            DataBufferUtils.release(join);

                            // 响应体
                            String responseResult = new String(content, StandardCharsets.UTF_8);
                            gatewayLog.setResponseData(responseResult);

                            return bufferFactory.wrap(content);
                        }));
                    }
                }
                return super.writeWith(body);
            }
        };
    }

    /**
     * 打印日志
     */
    private void writeAccessLog(GatewayLogDO gatewayLog) {
        log.info(gatewayLog.toString());
        gatewayLogService.addGatewayLog(gatewayLog);
    }

}