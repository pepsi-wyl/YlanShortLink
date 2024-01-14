package org.ylan.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.ylan.common.convention.exception.ServiceException;
import org.ylan.mapper.ShortLinkMapper;
import org.ylan.model.dto.req.*;
import org.ylan.model.dto.resp.*;
import org.ylan.model.entity.ShortLinkDO;
import org.ylan.service.RecycleBinService;
import org.ylan.utils.NetUtils;

import java.util.concurrent.TimeUnit;

import static org.ylan.common.constant.NetConstant.HTTP;
import static org.ylan.common.constant.RedisCacheConstant.GOTO_IS_NULL_SHORT_LINK_KEY;
import static org.ylan.common.constant.RedisCacheConstant.GOTO_SHORT_LINK_KEY;
import static org.ylan.common.convention.enums.RecycleBinCodeEnum.*;

/**
 * 回收站接口实现层
 *
 * @author ylan
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class RecycleBinServiceImpl extends ServiceImpl<ShortLinkMapper, ShortLinkDO> implements RecycleBinService {

    /**
     * Redis缓存
     */
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public Boolean saveRecycleBin(RecycleBinSaveReqDTO requestParam) {
        // 更新条件
        LambdaUpdateWrapper<ShortLinkDO> updateWrapper = Wrappers.lambdaUpdate(ShortLinkDO.class)
                .eq(ShortLinkDO::getGid, requestParam.getGid())
                .eq(ShortLinkDO::getFullShortUrl, NetUtils.removalProtocol(requestParam.getFullShortUrl()))
                .eq(ShortLinkDO::getEnableStatus, 0);
        // 更新实体数据
        ShortLinkDO shortLinkDO = ShortLinkDO.builder().enableStatus(1).build();

        // 执行更新操作
        int update = baseMapper.update(shortLinkDO, updateWrapper);
        if (update < 1){
            throw new ServiceException(RECYCLE_BIN_SAVE_ERROR);
        }

        // 删除 FullShortURL 值缓存
        stringRedisTemplate.delete(String.format(GOTO_SHORT_LINK_KEY, NetUtils.removalProtocol(requestParam.getFullShortUrl())));
        // 构建 NUll 值缓存
        stringRedisTemplate.opsForValue().set(String.format(GOTO_IS_NULL_SHORT_LINK_KEY, NetUtils.removalProtocol(requestParam.getFullShortUrl())), "-", 30, TimeUnit.MINUTES);

        return true;
    }

    @Override
    public Boolean recoverRecycleBin(RecycleBinRecoverReqDTO requestParam) {
        // 更新条件
        LambdaUpdateWrapper<ShortLinkDO> updateWrapper = Wrappers.lambdaUpdate(ShortLinkDO.class)
                .eq(ShortLinkDO::getGid, requestParam.getGid())
                .eq(ShortLinkDO::getFullShortUrl, NetUtils.removalProtocol(requestParam.getFullShortUrl()))
                .eq(ShortLinkDO::getEnableStatus, 1);
        // 更新实体数据
        ShortLinkDO shortLinkDO = ShortLinkDO.builder().enableStatus(0).build();

        // 执行更新操作
        int update = baseMapper.update(shortLinkDO, updateWrapper);
        if (update < 1){
            throw new ServiceException(RECYCLE_BIN_RECOVER_ERROR);
        }

        // 删除 Null 值缓存
        stringRedisTemplate.delete(String.format(GOTO_IS_NULL_SHORT_LINK_KEY, NetUtils.removalProtocol(requestParam.getFullShortUrl())));
        // TODO 缓存预热，构建 FullShortURL缓存，需要再做

        return true;
    }

    @Override
    public Boolean removeRecycleBin(RecycleBinRemoveReqDTO requestParam) {
        // 更新条件
        LambdaUpdateWrapper<ShortLinkDO> updateWrapper = Wrappers.lambdaUpdate(ShortLinkDO.class)
                .eq(ShortLinkDO::getGid, requestParam.getGid())
                .eq(ShortLinkDO::getFullShortUrl, NetUtils.removalProtocol(requestParam.getFullShortUrl()))
                .eq(ShortLinkDO::getEnableStatus, 1);

        // 执行删除操作
        int delete = baseMapper.delete(updateWrapper);
        if (delete < 1){
            throw new ServiceException(RECYCLE_BIN_REMOVE_ERROR);
        }
        // TODO 删除GOTO表，需要再做
        // TODO 删除统计缓存，需要再做
        return true;
    }

    @Override
    public IPage<RecycleBinPageRespDTO> pageRecycleBin(RecycleBinPageReqDTO requestParam) {
        // 参数GiList判断
        if (CollectionUtils.isEmpty(requestParam.getGidList())){
                throw new ServiceException(RECYCLE_BIN_PAGE_PARAM_ERROR);
        }

        // 查询条件
        LambdaQueryWrapper<ShortLinkDO> queryWrapper = Wrappers.lambdaQuery(ShortLinkDO.class)
                .in(ShortLinkDO::getGid, requestParam.getGidList())
                .eq(ShortLinkDO::getEnableStatus, 1)
                .orderByDesc(ShortLinkDO::getUpdateTime);
        // 查询page
        IPage<ShortLinkDO> resultPage = baseMapper.selectPage(requestParam, queryWrapper);

        // page记录类型转化
        return resultPage.convert((shortLinkDO)->{
            RecycleBinPageRespDTO bean = BeanUtil.toBean(shortLinkDO, RecycleBinPageRespDTO.class);
            bean.setFullShortUrl(HTTP + bean.getFullShortUrl());
            return bean;
        });
    }

}