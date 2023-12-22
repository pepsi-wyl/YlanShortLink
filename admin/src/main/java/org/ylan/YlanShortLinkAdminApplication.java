package org.ylan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ylan
 */

@SpringBootApplication
@MapperScan("org.ylan.mapper")
public class YlanShortLinkAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(YlanShortLinkAdminApplication.class, args);
    }
}