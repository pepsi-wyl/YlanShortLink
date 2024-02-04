package org.ylan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Gateway启动类
 *
 * @author ylan
 */

@MapperScan("org.ylan.mapper")
@SpringBootApplication
public class YlanShortLinkGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(YlanShortLinkGatewayApplication.class, args);
    }
}