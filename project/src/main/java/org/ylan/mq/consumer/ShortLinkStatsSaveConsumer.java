package org.ylan.mq.consumer;

import com.alibaba.fastjson2.JSON;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;
import org.ylan.common.convention.exception.ServiceException;
import org.ylan.model.dto.biz.ShortLinkStatsRecordDTO;
import org.ylan.mq.idempotent.MessageQueueIdempotentHandler;
import org.ylan.service.ShortLinkStatsService;

import java.util.Map;
import java.util.Objects;

/**
 * 短链接监控状态保存-消息队列消费者
 *
 * @author ylan
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class ShortLinkStatsSaveConsumer implements StreamListener<String, MapRecord<String, String, String>> {

    /**
     * StringRedisTemplate
     */
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 消息队列幂等处理器
     */
    private final MessageQueueIdempotentHandler messageQueueIdempotentHandler;

    /**
     * 短链接监控接口层
     */
    private final ShortLinkStatsService shortLinkStatsService;

    @Override
    public void onMessage(MapRecord<String, String, String> message) {

        // Stream
        String stream = message.getStream();
        // 消息Id
        RecordId id = message.getId();
        // 消息Value
        Map<String, String> producerMap = message.getValue();

        // 幂等判断
        if (messageQueueIdempotentHandler.isMessageProcessed(id.toString())) {
            if (messageQueueIdempotentHandler.isAccomplish(id.toString())) {
                return;
            }
            messageQueueIdempotentHandler.delMessageProcessed(id.toString());
            log.error("消息未完成流程，需要消息队列重试");
            throw new ServiceException("消息未完成流程，需要消息队列重试");
        }

        try {
            // 消费消息
            ShortLinkStatsRecordDTO statsRecord = JSON.parseObject(producerMap.get("statsRecord"), ShortLinkStatsRecordDTO.class);
            shortLinkStatsService.actualSaveShortLinkStats(statsRecord);
            // 确认消息
            stringRedisTemplate.opsForStream().delete(Objects.requireNonNull(stream), id.getValue());
        }catch (Throwable ex){
            messageQueueIdempotentHandler.delMessageProcessed(id.toString());
            log.error("记录短链接监控消费异常", ex);
            throw new ServiceException("记录短链接监控消费异常");
        }

        // 流程执行完成
        messageQueueIdempotentHandler.setAccomplish(id.toString());
    }

}