package org.ylan.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.stereotype.Component;

/**
 * @author ylan
 *
 * 定义QuartzJobFactory，通过 AutowireCapableBeanFactory 将创建好的 Job 对象交给 Spring 管理
 */

@Component
public class QuartzJobFactory extends SpringBeanJobFactory {

    private final AutowireCapableBeanFactory  beanFactory;

    public QuartzJobFactory(AutowireCapableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        beanFactory.autowireBean(jobInstance);
        return jobInstance;
    }

}