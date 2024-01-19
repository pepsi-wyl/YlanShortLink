package org.ylan.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * OpenFeign配置类
 *
 * @author ylan
 */

@Configuration
@EnableFeignClients("org.ylan.remote")
public class OpenFeignConfig {

}