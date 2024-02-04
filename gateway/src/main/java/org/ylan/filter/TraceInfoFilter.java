package org.ylan.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.ylan.common.constant.GateWayFilerOrderConstant.TRACE_INFO_FILTER_ORDER;
import static org.ylan.common.constant.LogsConstant.TRACE_ID;

/**
 * 链路追踪过滤器
 *
 * @author ylan
 */

@Slf4j
@Component
public class TraceInfoFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String traceId = UUID.randomUUID().toString().replace("-","");
        ServerHttpRequest request = exchange.getRequest().mutate().header(TRACE_ID, traceId).build();
        MDC.put(TRACE_ID, traceId);
        return chain.filter(exchange.mutate().request(request).build());
    }

    @Override
    public int getOrder() {
        return TRACE_INFO_FILTER_ORDER;
    }
}