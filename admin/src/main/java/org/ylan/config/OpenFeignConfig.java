package org.ylan.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.ylan.common.constant.LogsConstant.TRACE_ID;

/**
 * OpenFeign配置类
 *
 * @author ylan
 */

@Configuration
@EnableFeignClients("org.ylan.remote")
public class OpenFeignConfig implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 设置traceId到header中
        requestTemplate.header(TRACE_ID, MDC.get(TRACE_ID));
    }

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}