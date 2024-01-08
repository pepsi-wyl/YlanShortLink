package org.ylan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.ylan.common.log.LogsInterceptor;

/**
 * SpringWeb 拦截器配置
 *
 * @author ylan
 */

@Configuration
public class SpringBootWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 日志拦截器
        registry.addInterceptor(new LogsInterceptor());
    }
}