package org.ylan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ylan
 */

@SpringBootApplication
@MapperScan("org.ylan.mapper")
public class YlanShortLinkProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(YlanShortLinkProjectApplication.class, args);
    }
}