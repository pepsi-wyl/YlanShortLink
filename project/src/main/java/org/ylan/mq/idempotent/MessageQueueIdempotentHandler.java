package org.ylan.mq.idempotent;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.ylan.common.constant.RedisCacheConstant.IDEMPOTENT_KEY_PREFIX;

/**
 * 消息队列幂等处理器
 *
 * @author ylan
 */

@Component
@RequiredArgsConstructor
public class MessageQueueIdempotentHandler {

    /**
     * StringRedisTemplate
     */
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 未完成
     */
    private final String NOT_FINISH = "0";

    /**
     * 完成
     */
    private final String IS_FINISH = "1";

    /**
     * 判断当前消息是否消费过
     *
     * @param messageId 消息唯一标识
     * @return 消息是否消费过 消费过-true  没有消费过-false
     */
    public boolean isMessageProcessed(String messageId) {
        String key = IDEMPOTENT_KEY_PREFIX + messageId;
        return ! Boolean.TRUE.equals(stringRedisTemplate.opsForValue().setIfAbsent(key, NOT_FINISH, 2, TimeUnit.MINUTES));
    }

    /**
     * 如果消息处理遇到异常情况，删除幂等标识
     *
     * @param messageId 消息唯一标识
     */
    public void delMessageProcessed(String messageId) {
        String key = IDEMPOTENT_KEY_PREFIX + messageId;
        stringRedisTemplate.delete(key);
    }

    /**
     * 判断消息消费流程是否执行完成
     *
     * @param messageId 消息唯一标识
     * @return 消息是否执行完成
     */
    public boolean isAccomplish(String messageId) {
        String key = IDEMPOTENT_KEY_PREFIX + messageId;
        return Objects.equals(stringRedisTemplate.opsForValue().get(key), IS_FINISH);
    }

    /**
     * 设置消息流程执行完成
     *
     * @param messageId 消息唯一标识
     */
    public void setAccomplish(String messageId) {
        String key = IDEMPOTENT_KEY_PREFIX + messageId;
        stringRedisTemplate.opsForValue().set(key, IS_FINISH, 2, TimeUnit.MINUTES);
    }

}