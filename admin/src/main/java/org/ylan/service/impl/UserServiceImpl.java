package org.ylan.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ylan.common.convention.enums.UserErrorCodeEnum;
import org.ylan.common.convention.exception.ClientException;
import org.ylan.mapper.UserMapper;
import org.ylan.model.dto.resp.UserRespDTO;
import org.ylan.model.entity.UserDO;
import org.ylan.service.UserService;

import java.util.Objects;

/**
 * 用户接口实现层
 *
 * @author ylan
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Override
    public UserRespDTO getUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper =
                Wrappers.lambdaQuery(UserDO.class).eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);

        //  判断用户是否存在抛出业务异常
        if (Objects.isNull(userDO)){
            throw new ClientException(UserErrorCodeEnum.USER_NULL);
        }

        return BeanUtil.toBean(userDO, UserRespDTO.class);
    }
}