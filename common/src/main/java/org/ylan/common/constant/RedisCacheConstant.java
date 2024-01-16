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
     * 分组创建分布式锁key
     */
    public static final String LOCK_GROUP_CREATE_KEY = "YlanShortLink:lock_group-create:%s";

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

    /**
     * 防止用户注册查询数据库的布隆过滤器 Key
     */
    public static final String BLOOM_FILTER_USER_REGISTER = "userRegisterCachePenetrationBloomFilter";

    /**
     * 防止短链接创建查询数据库的布隆过滤器 key
     */
    public static final String BLOOM_FILTER_URI_CREATE = "shortUriCreateCachePenetrationBloomFilter";

    /**
     * 短链接监控状态UV状态前缀
     */
    public static final String SHORT_LINK_STATS_UV_PREFIX = "short-link:stats:uv:";

    /**
     * 短链接监控状态UIP状态前缀
     */
    public static final String SHORT_LINK_STATS_UIP_PREFIX = "short-link:stats:uip:";

    /**
     * 短链接修改分组 ID 锁前缀 Key
     */
    public static final String LOCK_GID_UPDATE_KEY = "short-link_lock_update-gid_%s";

    /**
     * 短链接延迟队列消费统计 Key
     */
    public static final String DELAY_QUEUE_STATS_KEY = "short-link_delay-queue:stats";

    /**
     * 幂等性key前缀
     */
    public static final String IDEMPOTENT_KEY_PREFIX = "short-link:idempotent:";
}