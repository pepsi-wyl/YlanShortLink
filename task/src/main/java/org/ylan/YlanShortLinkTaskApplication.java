package org.ylan;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

import static org.ylan.common.Date.DateFormatConstant.DATE_FORMAT_HH_MM_SS;

/**
 * SpringBoot-Task启动类
 *
 * @author ylan
 */

@MapperScan("org.ylan.mapper")
@SpringBootApplication
public class YlanShortLinkTaskApplication {

    /**
     * 日志记录器
     */
    private static final Logger log = LoggerFactory.getLogger(YlanShortLinkTaskApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(YlanShortLinkTaskApplication.class, args);
        log.info("YlanShortLinkTaskApplication started successfully, Current Thread : {}, The time is now {}", Thread.currentThread().getName(), DATE_FORMAT_HH_MM_SS.format(new Date()));
    }
}