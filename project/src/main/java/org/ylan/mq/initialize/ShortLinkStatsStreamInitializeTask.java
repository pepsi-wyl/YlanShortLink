package org.ylan.mq.initialize;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 初始化Redis Stream 消息队列 消费者组
 *
 * @author ylan
 */

@Component
@RequiredArgsConstructor
public class ShortLinkStatsStreamInitializeTask implements InitializingBean {

    /**
     * StringRedisTemplate
     */
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 消息队列Topic
     */
    @Value("${spring.data.redis.channel-topic.short-link-stats}")
    private String topic;

    /**
     * 消息队列Group
     */
    @Value("${spring.data.redis.channel-topic.short-link-stats-group}")
    private String group;

    @Override
    public void afterPropertiesSet() throws Exception {
        Boolean hasKey = stringRedisTemplate.hasKey(topic);
        if (Objects.isNull(hasKey) || !hasKey) {
            stringRedisTemplate.opsForStream().createGroup(topic, group);
        }
    }

}