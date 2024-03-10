package org.ylan.task.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.ylan.task.job.GateWayLogRestoreJob;

/**
 * 网关日志数据备份迁移任务配置
 *
 * @author ylan
 */

@Configuration
public class GateWayLogRestoreConfig {

    @Bean
    public JobDetail gateWayLogRestoreJobDetail() {
        return JobBuilder.newJob(GateWayLogRestoreJob.class)
                .withIdentity("GateWayLogRestoreJobDetail","GateWayLogRestoreJobDetail-Group")
                .withDescription("任务描述：网关日志数据备份迁移任务")
                .storeDurably()
                .build();
    }

    // 0/30 0 0-2 * * ?
    // 0 0 0-8 ? * MON-FRI 周一至周五的 0 点到 8 点之间每小时执行一次
    // 0/2 * * * * ?
    @Bean
    public Trigger gateWayLogRestoreJobTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(gateWayLogRestoreJobDetail())
                .withIdentity("GateWayLogRestoreJobTrigger", "GateWayLogRestoreJobTrigger-Group")
                .withSchedule(
                        CronScheduleBuilder
                                .cronSchedule("0 0 0-8 ? * MON-FRI")
                )
                .startNow()
                .build();
    }

}