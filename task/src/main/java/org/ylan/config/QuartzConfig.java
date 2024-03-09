package org.ylan.config;

import lombok.RequiredArgsConstructor;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author ylan
 *
 * Quartz 配置类
 */

@Configuration
@RequiredArgsConstructor
public class QuartzConfig {

    /**
     * 注入QuartzJobFactory
     */
    private final QuartzJobFactory quartzJobFactory;

    /**
     * 设置Scheduler对象
     *
     * @return Scheduler
     * @throws IOException io
     */
    @Bean
    public Scheduler scheduler() throws SchedulerException {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        // 设置QuartzJobFactory
        scheduler.setJobFactory(quartzJobFactory);
        return scheduler;
    }

}