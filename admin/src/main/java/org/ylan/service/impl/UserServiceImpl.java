package org.ylan.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.ylan.common.bit.user.UserContext;
import org.ylan.common.convention.enums.UserErrorCodeEnum;
import org.ylan.common.convention.exception.ClientException;
import org.ylan.common.convention.exception.ServiceException;
import org.ylan.mapper.UserMapper;
import org.ylan.model.dto.req.GroupSaveReqDTO;
import org.ylan.model.dto.req.UserLoginReqDTO;
import org.ylan.model.dto.req.UserRegisterReqDTO;
import org.ylan.model.dto.req.UserUpdateReqDTO;
import org.ylan.model.dto.resp.UserLoginRespDTO;
import org.ylan.model.dto.resp.UserRespDTO;
import org.ylan.model.entity.UserDO;
import org.ylan.service.GroupService;
import org.ylan.service.UserService;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.ylan.common.constant.RedisCacheConstant.LOCK_USER_REGISTER_KEY;
import static org.ylan.common.constant.RedisCacheConstant.LOGIN_PREFIX;
import static org.ylan.common.convention.enums.UserErrorCodeEnum.*;

/**
 * 用户接口实现层
 *
 * @author ylan
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    /**
     * 防止用户注册查询数据库的布隆过滤器
     */
    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;

    /**
     * 短链接分组服务
     */
    private final GroupService groupService;

    /**
     * RedissonClient分布式锁
     */
    private final RedissonClient redissonClient;

    /**
     * StringRedisTemplate 操作redis
     */
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public UserRespDTO getUserByUsername(String username) {

        // 利用布隆过滤器过滤不存在的请求，避免直接查询数据库
        if (!hasUserByUsername(username)) {
            throw new ClientException(USER_NULL);
        }

        LambdaQueryWrapper<UserDO> queryWrapper =
                Wrappers.lambdaQuery(UserDO.class).eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);

        //  判断用户是否存在抛出业务异常
        if (Objects.isNull(userDO)) {
            throw new ServiceException(UserErrorCodeEnum.USER_NULL);
        }

        return BeanUtil.toBean(userDO, UserRespDTO.class);
    }

    @Override
    public Boolean hasUserByUsername(String username) {
        return userRegisterCachePenetrationBloomFilter.contains(username);
    }

    @Override
    public void register(UserRegisterReqDTO requestParam) {

        // 利用布隆过滤器防止用户注册查询数据库检查用户名是否已经存在
        if (hasUserByUsername(requestParam.getUsername())) {
            throw new ClientException(USER_NAME_EXIST);
        }

        // 利用Redisson分布式锁防止用户注册重复提交
        RLock lock = redissonClient.getLock(LOCK_USER_REGISTER_KEY + requestParam.getUsername());
        boolean isLocked = lock.tryLock();

        // 获取到分布式锁
        if (isLocked) {
            log.info("分布式锁{}获取成功, 开始执行注册逻辑", LOCK_USER_REGISTER_KEY + requestParam.getUsername());
            try {
                // 插入用户数据
                int inserted = baseMapper.insert(BeanUtil.toBean(requestParam, UserDO.class));
                if (inserted < 0) {
                    //  插入失败抛出业务异常
                    throw new ClientException(USER_SAVE_ERROR);
                }

                // 用户数据插入布隆过滤器
                userRegisterCachePenetrationBloomFilter.add(requestParam.getUsername());
                // 用户创建默认分组
                groupService.saveGroup(requestParam.getUsername(),GroupSaveReqDTO.builder().name("默认分组").build());
            } catch (DuplicateKeyException ex) {
                //  用户名重复抛出业务异常 数据库层username设置为唯一索引
                throw new ClientException(USER_EXIST);
            } finally {
                lock.unlock();
            }
            return;
        }

        // 没有获取到分布式锁直接抛出用户名已经存在的业务异常
        log.info("分布式锁{}获取失败,用户注册请求被拒绝", LOCK_USER_REGISTER_KEY + requestParam.getUsername());
        throw new ClientException(USER_NAME_EXIST);
    }

    @Override
    public void update(UserUpdateReqDTO requestParam) {

        //  校验用户是否为当前登录用户
        if (!Objects.equals(UserContext.getUsername(), requestParam.getUsername())){
            throw new ClientException(USER_NOT_LOGIN_ERROR);
        }

        // 利用布隆过滤器过滤不存在的请求，避免直接查询数据库
        if (!hasUserByUsername(requestParam.getUsername())) {
            throw new ClientException(USER_NULL);
        }

        // 修改用户
        LambdaUpdateWrapper<UserDO> updateWrapper =
                Wrappers.lambdaUpdate(UserDO.class).eq(UserDO::getUsername, requestParam.getUsername());
        int update = baseMapper.update(BeanUtil.toBean(requestParam, UserDO.class), updateWrapper);
        if (update < 0){
            // 修改用户异常
           throw new ClientException(USER_UPDATE_ERROR);
        }

    }

    @Override
    public UserLoginRespDTO login(UserLoginReqDTO requestParam) {

        // 利用布隆过滤器过滤不存在的请求，避免直接查询数据库
        if (!hasUserByUsername(requestParam.getUsername())) {
            // 用户登录失败,用户名或密码错误
            throw new ClientException(USER_LOGIN_ERROR);
        }

//        // 根据Redis中数据判断是否重复登陆，防止重复刷接口
//        Boolean hasLogin = stringRedisTemplate.hasKey(LOGIN_PREFIX + requestParam.getUsername());
//        if (hasLogin != null && hasLogin){
//            // 重复登陆错误
//            throw new ClientException(USER_REPEAT_LOGIN_ERROR);
//        }

        // 查询Redis中存储的用户信息，如果用户重复登陆则直接返回用户Token
        Map<Object ,Object> hasLoginMap = stringRedisTemplate.opsForHash().entries(LOGIN_PREFIX + requestParam.getUsername());
        if (CollUtil.isNotEmpty(hasLoginMap)) {
            String token = hasLoginMap.keySet().stream()
                    .findFirst()
                    .map(Object::toString)
                    .orElseThrow(() -> new ClientException("用户登录错误"));
            return new UserLoginRespDTO(token);
        }

        // 查询数据库判断用户是否可以登陆
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, requestParam.getUsername())
                .eq(UserDO::getPassword, requestParam.getPassword());
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        if (Objects.isNull(userDO)){
            // 用户登录失败,用户名或密码错误
            throw new ClientException(USER_LOGIN_ERROR);
        }

        // 生成token
        String token = UUID.randomUUID().toString();

        // 存入redis
        stringRedisTemplate.opsForHash().put(LOGIN_PREFIX + requestParam.getUsername(), token, JSON.toJSONString(userDO));
        stringRedisTemplate.expire(LOGIN_PREFIX + requestParam.getUsername(), 30L, TimeUnit.MINUTES);

        return UserLoginRespDTO.builder().token(token).build();
    }

    @Override
    public Boolean checkLogin(String username, String token) {
        return !Objects.isNull(stringRedisTemplate.opsForHash().get(LOGIN_PREFIX + username, token));
    }

    @Override
    public Boolean logout(String username, String token) {
        Boolean isLogin = checkLogin(username, token);
        if (isLogin) {
            // 删除Redis中登陆的信息
            stringRedisTemplate.delete(LOGIN_PREFIX + username);
            // 设置注销时间戳
            LambdaUpdateWrapper<UserDO> updateWrapper =
                    Wrappers.lambdaUpdate(UserDO.class).eq(UserDO::getUsername, username);
            int update = baseMapper.update(UserDO.builder().deletionTime(System.currentTimeMillis()).build(), updateWrapper);
            if (update < 0){
                throw new ClientException(USER_LOGOUT_UPDATE_ERROR);
            }
            return true;
        }
        throw new ClientException(USER_LOGOUT_ERROR);
    }

}