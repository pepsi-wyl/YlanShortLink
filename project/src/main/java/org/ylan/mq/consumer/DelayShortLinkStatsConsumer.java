package org.ylan.mq.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.ylan.common.convention.exception.ServiceException;
import org.ylan.model.dto.biz.ShortLinkStatsRecordDTO;
import org.ylan.mq.idempotent.MessageQueueIdempotentHandler;
import org.ylan.service.ShortLinkStatsService;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

import static org.ylan.common.constant.RedisCacheConstant.DELAY_QUEUE_STATS_KEY;

/**
 * 延迟记录短链接统计组件
 *
 * @author ylan
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class DelayShortLinkStatsConsumer implements InitializingBean {

    /**
     * RedissonClient
     */
    private final RedissonClient redissonClient;

    /**
     * 消息队列幂等处理器
     */
    private final MessageQueueIdempotentHandler messageQueueIdempotentHandler;

    /**
     * 短链接监控接口层
     */
    private final ShortLinkStatsService shortLinkStatsService;

    public void onMessage() {
        Executors.newSingleThreadExecutor(
                        runnable -> {
                            Thread thread = new Thread(runnable);
                            thread.setName("delay_short-link_stats_consumer");
                            thread.setDaemon(Boolean.TRUE);
                            return thread;
                        })
                .execute(() -> {
                    RBlockingDeque<ShortLinkStatsRecordDTO> blockingDeque = redissonClient.getBlockingDeque(DELAY_QUEUE_STATS_KEY);
                    RDelayedQueue<ShortLinkStatsRecordDTO> delayedQueue = redissonClient.getDelayedQueue(blockingDeque);
                    while (true){
                        try {
                            ShortLinkStatsRecordDTO statsRecord = delayedQueue.poll();
                            if (statsRecord != null) {
                                String id = statsRecord.getKeys();

                                // 幂等判断
                                if (messageQueueIdempotentHandler.isMessageProcessed(id)) {
                                    if (messageQueueIdempotentHandler.isAccomplish(id)) {
                                        return;
                                    }
                                    messageQueueIdempotentHandler.delMessageProcessed(id);
                                    log.error("消息未完成流程，需要消息队列重试");
                                    throw new ServiceException("消息未完成流程，需要消息队列重试");
                                }

                                try {
                                    // 消费消息
                                    shortLinkStatsService.shortLinkStats(statsRecord);
                                } catch (Throwable ex) {
                                    messageQueueIdempotentHandler.delMessageProcessed(statsRecord.getKeys());
                                    log.error("延迟记录短链接监控消费异常", ex);
                                }

                                // 流程执行完成
                                messageQueueIdempotentHandler.setAccomplish(statsRecord.getKeys());
                                continue;
                            }
                            LockSupport.parkUntil(500);
                        } catch (Throwable ignored) {
                        }
                    }
                });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        onMessage();
    }
}