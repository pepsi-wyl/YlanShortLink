package org.ylan.filter;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.ylan.common.convention.result.GatewayErrorResult;
import org.ylan.config.Config;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

import static org.ylan.common.constant.RedisCacheConstant.LOGIN_PREFIX;
import static org.ylan.common.constant.UserTransmitConstant.*;
import static org.ylan.common.constant.UserTransmitConstant.TOKEN;

/**
 * SpringCloud Gateway Token 拦截器
 *
 * @author ylan
 */

@Component
public class TokenValidateGatewayFilterFactory extends AbstractGatewayFilterFactory<Config> {

    /**
     * StringRedisTemplate 操作redis
     */
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 构造函数
     */
    public TokenValidateGatewayFilterFactory(StringRedisTemplate stringRedisTemplate) {
        super(Config.class);
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * Token 拦截器 代码实现逻辑
     */
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {

            // 获取Request
            ServerHttpRequest request = exchange.getRequest();

            // 获取RequestPath  RequestMethod
            String requestPath = request.getPath().toString();
            String requestMethod = request.getMethod().name();

            // 判断是否在白名单中
            if (!isPathInWhiteList(requestPath, requestMethod, config.getWhitePathList())) {

                // 获取请求中的 username 和 token
                String username = request.getHeaders().getFirst(USER_NAME);
                String token = request.getHeaders().getFirst(TOKEN);

                // 设置 userInfo 用户信息
                Object userInfo;
                // username不为空 token不为空 并从redis中取出登陆信息
                if (StringUtils.hasText(username) && StringUtils.hasText(token) && !Objects.isNull((userInfo = stringRedisTemplate.opsForHash().get(LOGIN_PREFIX + username, token)))) {
                    // userInfo 用户信息 转化为Json
                    JSONObject userInfoJsonObject = JSON.parseObject(userInfo.toString());
                    // 设置请求头
                    ServerHttpRequest.Builder builder = exchange.getRequest().mutate().headers(httpHeaders -> {
                        String userId = userInfoJsonObject.getString(USER_ID);
                        String realName = URLEncoder.encode(userInfoJsonObject.getString(USER_REAL_NAME), StandardCharsets.UTF_8);
                        httpHeaders.set(HTTP_HEADER_USER_ID, userId);
                        httpHeaders.set(HTTP_HEADER_USER_REAL_NAME, realName);
                    });
                    return chain.filter(exchange.mutate().request(builder.build()).build());
                }

                //  返回401状态码
                ServerHttpResponse response = exchange.getResponse();
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.writeWith(Mono.fromSupplier(() -> {
                    DataBufferFactory bufferFactory = response.bufferFactory();
                    GatewayErrorResult resultMessage = GatewayErrorResult.builder()
                            .status(HttpStatus.UNAUTHORIZED.value())
                            .message("Token validation error")
                            .build();
                    return bufferFactory.wrap(JSON.toJSONString(resultMessage).getBytes());
                }));
            }

            // 执行下一个过滤器
            return chain.filter(exchange);
        };
    }

    /**
     * 接口是否在白名单
     */
    private boolean isPathInWhiteList(String requestPath, String requestMethod, List<String> whitePathList) {
        return
                (!CollectionUtils.isEmpty(whitePathList) && whitePathList.stream().anyMatch(requestPath::startsWith))
                ||
                (Objects.equals(REGISTER_API, requestPath) && Objects.equals(REGISTER_API_METHOD, requestMethod));
    }

}