package org.ylan.mq.producer;

import lombok.RequiredArgsConstructor;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;
import org.ylan.model.dto.biz.ShortLinkStatsRecordDTO;
import java.util.concurrent.TimeUnit;

import static org.ylan.common.constant.RedisCacheConstant.DELAY_QUEUE_STATS_KEY;

/**
 * 延迟消费短链接统计发送者
 *
 * @author ylan
 */

@Component
@RequiredArgsConstructor
public class DelayShortLinkStatsProducer {

    /**
     * Redisson客户端
     */
    private final RedissonClient redissonClient;

    /**
     * 发送延迟消费短链接统计
     *
     * @param statsRecord 短链接统计实体参数
     */
    public void send(ShortLinkStatsRecordDTO statsRecord) {
        RBlockingDeque<ShortLinkStatsRecordDTO> blockingDeque = redissonClient.getBlockingDeque(DELAY_QUEUE_STATS_KEY);
        RDelayedQueue<ShortLinkStatsRecordDTO> delayedQueue = redissonClient.getDelayedQueue(blockingDeque);
        delayedQueue.offer(statsRecord, 5, TimeUnit.SECONDS);
    }
}