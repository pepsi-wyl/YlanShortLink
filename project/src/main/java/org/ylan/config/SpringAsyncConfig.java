package org.ylan.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Spring @Async 配置类
 * @author ylan
 */

@Slf4j
@EnableAsync    // 开启异步任务支持
@Configuration  // 配置类注解
public class SpringAsyncConfig implements AsyncConfigurer {

    // 自定义线程池
    @Bean(name = "threadPoolTaskExecutor")
    public Executor executor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 线程名称的前缀
        executor.setThreadNamePrefix("threadPoolTaskExecutor-");

        // 核心线程池数量
        executor.setCorePoolSize(10);
        // 最大线程数量
        executor.setMaxPoolSize(50);
        // 线程池的队列容量
        executor.setQueueCapacity(10);
        // 空闲线程的存活时间
        executor.setKeepAliveSeconds(60);
        // 用来设置 线程池关闭 的时候 等待 所有任务都完成后，再继续 销毁 其他的 Bean，这样这些 异步任务 的 销毁 就会先于 数据库连接池对象 的销毁。
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 任务的等待时间 如果超过这个时间还没有销毁就 强制销毁，以确保应用最后能够被关闭，而不是阻塞住。
        executor.setAwaitTerminationSeconds(60);

        // setRejectedExecutionHandler：当pool已经达到max size的时候，如何处理新任务
        // CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 初始化
        executor.initialize();
        return executor;
    }

    /**
     * 异步任务执行器
     *
     * @return Executor
     */
    @Override
    public Executor getAsyncExecutor() {
        return executor();
    }

    /**
     * 异步任务中异常处理
     *
     * @return AsyncUncaughtExceptionHandler
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (Throwable ex, Method method, Object... params)->{
            // todo 异步方法异常处理
            log.error("class#method: {}" , method.getDeclaringClass().getName() + "#" + method.getName());
            log.error("type        : {}" , ex.getClass().getName());
            log.error("exception   : {}" , ex.getMessage());
        };
    }

}