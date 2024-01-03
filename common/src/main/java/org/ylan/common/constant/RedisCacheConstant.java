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

    /**
     * 短链接跳转前缀 Key
     */
    public static final String GOTO_SHORT_LINK_KEY = "short-link_goto_%s";

    /**
     * 短链接空值跳转前缀 Key
     */
    public static final String GOTO_IS_NULL_SHORT_LINK_KEY = "short-link_is-null_goto_%s";

    /**
     * 短链接跳转锁前缀 分布式锁 Key
     */
    public static final String LOCK_GOTO_SHORT_LINK_KEY = "short-link_lock_goto_%s";
}