package org.ylan.service.impl;

import cn.hutool.core.bean.BeanUtil;
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
import org.springframework.stereotype.Service;
import org.ylan.common.convention.enums.UserErrorCodeEnum;
import org.ylan.common.convention.exception.ClientException;
import org.ylan.mapper.UserMapper;
import org.ylan.model.dto.req.UserRegisterReqDTO;
import org.ylan.model.dto.req.UserUpdateReqDTO;
import org.ylan.model.dto.resp.UserRespDTO;
import org.ylan.model.entity.UserDO;
import org.ylan.service.UserService;

import java.util.Objects;

import static org.ylan.common.constant.RedisCacheConstant.LOCK_USER_REGISTER_KEY;
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
     * RedissonClient分布式锁
     */
    private final RedissonClient redissonClient;

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
            throw new ClientException(UserErrorCodeEnum.USER_NULL);
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

        // TODO 验证当前用户名是否为登录用户

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

}