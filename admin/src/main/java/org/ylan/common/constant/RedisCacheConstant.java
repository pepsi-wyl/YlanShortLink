package org.ylan.common.constant;

/**
 * Redis 缓存常量类
 *
 * @author ylan
 */
public class RedisCacheConstant {

    /**
     * 用户注册分布式锁key
     */
    public static final String LOCK_USER_REGISTER_KEY = "YlanShortLink:lock_user-register:";

    /**
     * 用户登陆缓存RedisKey前缀
     */
    public static final String LOGIN_PREFIX = "login_";
}