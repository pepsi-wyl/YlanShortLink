package org.ylan.mq.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 短链接监控状态保存-消息队列生产者
 *
 * @author ylan
 */

@Component
@RequiredArgsConstructor
public class ShortLinkStatsSaveProducer {

    /**
     * 注入StringRedisTemplate
     */
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 消息队列Topic
     */
    @Value("${spring.data.redis.channel-topic.short-link-stats}")
    private String topic;

    /**
     * 发送短链接监控状态消息
     */
    public void send(Map<String, String> producerMap) {
        stringRedisTemplate.opsForStream().add(topic, producerMap);
    }

}