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
import org.springframework.transaction.annotation.Transactional;
import org.ylan.common.convention.exception.ServiceException;
import org.ylan.mapper.*;
import org.ylan.model.dto.req.RecycleBinPageReqDTO;
import org.ylan.model.dto.req.RecycleBinRecoverReqDTO;
import org.ylan.model.dto.req.RecycleBinRemoveReqDTO;
import org.ylan.model.dto.req.RecycleBinSaveReqDTO;
import org.ylan.model.dto.resp.RecycleBinPageRespDTO;
import org.ylan.model.entity.LinkAccessLogsDO;
import org.ylan.model.entity.ShortLinkDO;
import org.ylan.model.entity.ShortLinkGotoDO;
import org.ylan.service.RecycleBinService;
import org.ylan.utils.NetUtils;

import java.util.concurrent.TimeUnit;

import static org.ylan.common.constant.RedisCacheConstant.*;
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

    /**
     * 回收站持久层
     */
    private final RecycleBinMapper recycleBinMapper;

    /**
     * 短链接跳转持久层
     */
    private final ShortLinkGotoMapper shortLinkGotoMapper;

    /**
     * 短链接基础访问监控持久层
     */
    private final LinkAccessStatsMapper linkAccessStatsMapper;

    /**
     * 短链接地区统计访问持久层
     */
    private final LinkLocaleStatsMapper linkLocaleStatsMapper;

    /**
     * 短链接浏览器访问监控持久层
     */
    private final LinkBrowserStatsMapper linkBrowserStatsMapper;

    /**
     * 操作系统统计访问监控持久层
     */
    private final LinkOsStatsMapper linkOsStatsMapper;

    /**
     * 短链接设备访问持久层
     */
    private final LinkDeviceStatsMapper linkDeviceStatsMapper;

    /**
     * 短链接网络访问统计访问持久层
     */
    private final LinkNetworkStatsMapper linkNetworkStatsMapper;

    /**
     * 短链接访问日志监控持久层
     */
    private final LinkAccessLogsMapper linkAccessLogsMapper;

    /**
     * 短链接今日统计持久层
     */
    private final LinkStatsTodayMapper linkStatsTodayMapper;

    @Override
    public Boolean saveRecycleBin(RecycleBinSaveReqDTO requestParam) {
        // 更新条件
        LambdaUpdateWrapper<ShortLinkDO> updateWrapper = Wrappers.lambdaUpdate(ShortLinkDO.class)
                .eq(ShortLinkDO::getGid, requestParam.getGid())
                .eq(ShortLinkDO::getFullShortUrl, NetUtils.removalProtocol(requestParam.getFullShortUrl()))
                .eq(ShortLinkDO::getEnableStatus, 0)
                .eq(ShortLinkDO::getDelTime, 0L);
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
                .eq(ShortLinkDO::getEnableStatus, 1)
                .eq(ShortLinkDO::getDelTime, 0L);
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean removeRecycleBin(RecycleBinRemoveReqDTO requestParam) {

        // 执行删除操作
        int delete = recycleBinMapper.removeRecycleBin(requestParam.getGid(),NetUtils.removalProtocol(requestParam.getFullShortUrl()), System.currentTimeMillis());
        if (delete < 1){
            throw new ServiceException(RECYCLE_BIN_REMOVE_ERROR);
        }

        // GoTo表
        LambdaQueryWrapper<ShortLinkGotoDO> wrapperShortLinkGotoDO = Wrappers.lambdaQuery(ShortLinkGotoDO.class)
                .eq(ShortLinkGotoDO::getGid, requestParam.getGid())
                .eq(ShortLinkGotoDO::getFullShortUrl, NetUtils.removalProtocol(requestParam.getFullShortUrl()));
        shortLinkGotoMapper.delete(wrapperShortLinkGotoDO);

        // 统计信息
        linkAccessStatsMapper.deleteByGidAndFullShortUrl(requestParam.getGid(), NetUtils.removalProtocol(requestParam.getFullShortUrl()));
        linkStatsTodayMapper.deleteByGidAndFullShortUrl(requestParam.getGid(), NetUtils.removalProtocol(requestParam.getFullShortUrl()));
        linkLocaleStatsMapper.deleteByGidAndFullShortUrl(requestParam.getGid(), NetUtils.removalProtocol(requestParam.getFullShortUrl()));
        linkBrowserStatsMapper.deleteByGidAndFullShortUrl(requestParam.getGid(), NetUtils.removalProtocol(requestParam.getFullShortUrl()));
        linkOsStatsMapper.deleteByGidAndFullShortUrl(requestParam.getGid(), NetUtils.removalProtocol(requestParam.getFullShortUrl()));
        linkDeviceStatsMapper.deleteByGidAndFullShortUrl(requestParam.getGid(), NetUtils.removalProtocol(requestParam.getFullShortUrl()));
        linkNetworkStatsMapper.deleteByGidAndFullShortUrl(requestParam.getGid(), NetUtils.removalProtocol(requestParam.getFullShortUrl()));
        LambdaQueryWrapper<LinkAccessLogsDO> wrapperLinkAccessLogsDO = Wrappers.lambdaQuery(LinkAccessLogsDO.class)
                .eq(LinkAccessLogsDO::getGid, requestParam.getGid())
                .eq(LinkAccessLogsDO::getFullShortUrl, NetUtils.removalProtocol(requestParam.getFullShortUrl()));
        linkAccessLogsMapper.delete(wrapperLinkAccessLogsDO);

        // 删除统计缓存
        stringRedisTemplate.delete(SHORT_LINK_STATS_UV_PREFIX + NetUtils.removalProtocol(requestParam.getFullShortUrl()));
        stringRedisTemplate.delete(SHORT_LINK_STATS_UIP_PREFIX + NetUtils.removalProtocol(requestParam.getFullShortUrl()));

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
//            bean.setFullShortUrl(HTTP + bean.getFullShortUrl());
            return bean;
        });
    }

}