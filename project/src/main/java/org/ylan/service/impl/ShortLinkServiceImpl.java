package org.ylan.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylan.common.convention.enums.VailDateTypeEnum;
import org.ylan.common.convention.exception.ServiceException;
import org.ylan.config.GotoDomainWhiteListConfiguration;
import org.ylan.mapper.*;
import org.ylan.model.dto.biz.ShortLinkStatsRecordDTO;
import org.ylan.model.dto.req.ShortLinkBatchCreateReqDTO;
import org.ylan.model.dto.req.ShortLinkCreateReqDTO;
import org.ylan.model.dto.req.ShortLinkPageReqDTO;
import org.ylan.model.dto.req.ShortLinkUpdateReqDTO;
import org.ylan.model.dto.resp.*;
import org.ylan.model.entity.*;
import org.ylan.service.*;
import org.ylan.utils.HashUtils;
import org.ylan.utils.LinkUtil;
import org.ylan.utils.NetUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.ylan.common.constant.NetConstant.*;
import static org.ylan.common.constant.RedisCacheConstant.*;
import static org.ylan.common.convention.enums.GroupErrorCodeEnum.GROUP_HAS_RECYCLE_BIN_SHORT_LINK_ERROR;
import static org.ylan.common.convention.enums.GroupErrorCodeEnum.GROUP_HAS_SHORT_LINK;
import static org.ylan.common.convention.enums.ShortLinkErrorCodeEnum.*;

/**
 * 短链接接口实现层
 *
 * @author ylan
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ShortLinkServiceImpl extends ServiceImpl<ShortLinkMapper, ShortLinkDO> implements ShortLinkService {

    /**
     * 防止短链接创建查询数据库的布隆过滤器
     */
    private final RBloomFilter<String> shortUriCreateCachePenetrationBloomFilter;

    /**
     * Redis缓存
     */
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * Redis分布式锁
     */
    private final RedissonClient redissonClient;

    /**
     * 短链接跳转持久层
     */
    private final ShortLinkGotoMapper shortLinkGotoMapper;

    /**
     * 短链接监控服务
     */
    private final ShortLinkStatsService shortLinkStatsService;

    /**
     * 短链接持久层
     */
    private final ShortLinkMapper shortLinkMapper;

    /**
     * 短链接基础访问监控持久层
     */
    private final LinkAccessStatsMapper linkAccessStatsMapper;

    /**
     * 短链接基础访问监控接口层
     */
    private final LinkAccessStatsService linkAccessStatsService;

    /**
     * 短链接地区统计访问持久层
     */
    private final LinkLocaleStatsMapper linkLocaleStatsMapper;

    /**
     * 短链接地区统计访问接口层
     */
    private final LinkLocaleStatsService linkLocaleStatsService;

    /**
     * 短链接浏览器访问监控持久层
     */
    private final LinkBrowserStatsMapper linkBrowserStatsMapper;

    /**
     * 短链接浏览器访问监控接口层
     */
    private final LinkBrowserStatsService linkBrowserStatsService;

    /**
     * 操作系统统计访问监控持久层
     */
    private final LinkOsStatsMapper linkOsStatsMapper;

    /**
     * 操作系统统计访问监控接口层
     */
    private final LinkOsStatsService linkOsStatsService;

    /**
     * 短链接设备访问持久层
     */
    private final LinkDeviceStatsMapper linkDeviceStatsMapper;

    /**
     * 短链接设备访问接口层
     */
    private final LinkDeviceStatsService linkDeviceStatsService;

    /**
     * 短链接网络访问统计访问持久层
     */
    private final LinkNetworkStatsMapper linkNetworkStatsMapper;

    /**
     * 短链接网络访问统计访问接口层
     */
    private final LinkNetworkStatsService linkNetworkStatsService;

    /**
     * 短链接访问日志监控持久层
     */
    private final LinkAccessLogsMapper linkAccessLogsMapper;

    /**
     * 短链接访问日志监控接口层
     */
    private final LinkAccessLogsService linkAccessLogsService;

    /**
     * 短链接今日统计持久层
     */
    private final LinkStatsTodayMapper linkStatsTodayMapper;

    /**
     * 短链接今日统计接口层
     */
    private final LinkStatsTodayService linkStatsTodayService;

    /**
     * 白名单配置类
     */
    private final GotoDomainWhiteListConfiguration gotoDomainWhiteListConfiguration;

    /**
     * 默认生成短链接域名
     */
    @Value("${short-link.domain.default}")
    private String defaultShortLinkDomain;

    @SneakyThrows
    @Override
    public void restoreUrl(String shortUri, ServletRequest request, ServletResponse response) {
        String domain = request.getServerName();
        String serverPort = Optional.of(request.getServerPort())
                .filter(port -> !Objects.equals(port, PORT_80)) // 80 端口过滤
                .map(String::valueOf)
                .map(port -> PORT_SPLIT + port)
                .orElse(PORT_EMPTY);
        String fullShortUrl = domain + serverPort + URL_SPLIT + shortUri;

        // 利用 布隆过滤器 进行过滤 ，不存在的FullShortUrl 直接过滤 并跳转不存在
        boolean bLoomFilterContain = shortUriCreateCachePenetrationBloomFilter.contains(fullShortUrl);
        if (!bLoomFilterContain) {
            jumpNotFound(request, response, fullShortUrl, null);
            return;
        }

        // 查询缓存 判断缓存中是否存在 要跳转的FullShortUrl，存在直接返回
        String originalLink = stringRedisTemplate.opsForValue().get(String.format(GOTO_SHORT_LINK_KEY, fullShortUrl));
        if (StringUtils.isNotBlank(originalLink)) {
            // 监控统计
            ShortLinkStatsRecordDTO statsRecord = shortLinkStatsService.buildLinkStatsRecordAndSetUser(null, fullShortUrl, request, response);
            shortLinkStatsService.shortLinkStats(statsRecord);
            // 浏览器302重定向URL
            jumpLink(request, response, fullShortUrl, originalLink);
            return;
        }

        // 查询缓存 判断缓存中是否存在 Null值FullShortUrl，存在直接返回，避免查询数据库 造成缓存穿透 并跳转不存在
        String gotoIsNullShortLink = stringRedisTemplate.opsForValue().get(String.format(GOTO_IS_NULL_SHORT_LINK_KEY, fullShortUrl));
        if (StringUtils.isNotBlank(gotoIsNullShortLink)) {
            jumpNotFound(request, response, fullShortUrl, originalLink);
            return;
        }

        // 分布式锁锁住相同FullShortUrl的请求，只能由一个去构建缓存
        RLock lock = redissonClient.getLock(String.format(LOCK_GOTO_SHORT_LINK_KEY, fullShortUrl));
        lock.lock();
        try {
            // 双重检查 检查是否有请求构建跳转的FullShortUrl缓存成功
            originalLink = stringRedisTemplate.opsForValue().get(String.format(GOTO_SHORT_LINK_KEY, fullShortUrl));
            if (StringUtils.isNotBlank(originalLink)) {
                // 监控统计
                ShortLinkStatsRecordDTO statsRecord = shortLinkStatsService.buildLinkStatsRecordAndSetUser(null, fullShortUrl, request, response);
                shortLinkStatsService.shortLinkStats(statsRecord);
                // 浏览器302重定向URL
                jumpLink(request, response, fullShortUrl, originalLink);
                return;
            }

            // 双重检查 检查是否有请求构建构建Null值FullShortUrl缓存成功
            gotoIsNullShortLink = stringRedisTemplate.opsForValue().get(String.format(GOTO_IS_NULL_SHORT_LINK_KEY, fullShortUrl));
            if (StringUtils.isNotBlank(gotoIsNullShortLink)) {
                jumpNotFound(request, response, fullShortUrl, originalLink);
                return;
            }

            // 根据短链接查询GoTo路由表
            LambdaQueryWrapper<ShortLinkGotoDO> linkGotoQueryWrapper =
                    Wrappers.lambdaQuery(ShortLinkGotoDO.class).eq(ShortLinkGotoDO::getFullShortUrl, fullShortUrl);
            ShortLinkGotoDO shortLinkGotoDO = shortLinkGotoMapper.selectOne(linkGotoQueryWrapper);
            // 如果路由表中不存在则直接 构建Null值FullShortUrl 缓存 30分钟 并跳转不存在
            if (Objects.isNull(shortLinkGotoDO)) {
                stringRedisTemplate.opsForValue().set(String.format(GOTO_IS_NULL_SHORT_LINK_KEY, fullShortUrl), "-", 30, TimeUnit.MINUTES);
                jumpNotFound(request, response, fullShortUrl, originalLink);
                return;
            }

            // 查询短链接表
            LambdaQueryWrapper<ShortLinkDO> shortLinkQueryWrapper = Wrappers.lambdaQuery(ShortLinkDO.class)
                    .eq(ShortLinkDO::getGid, shortLinkGotoDO.getGid())
                    .eq(ShortLinkDO::getFullShortUrl, fullShortUrl)
                    .eq(ShortLinkDO::getEnableStatus, 0);
            ShortLinkDO shortLinkDO = baseMapper.selectOne(shortLinkQueryWrapper);
            // 如果短链接表不存在 或者 短链接有效期过期 构建Null值FullShortUrl 缓存 30分钟 并跳转不存在
            if (Objects.isNull(shortLinkDO) || (VailDateTypeEnum.CUSTOM.getType().equals(shortLinkDO.getValidDateType()) && shortLinkDO.getValidDate().before(new Date()))) {
                stringRedisTemplate.opsForValue().set(String.format(GOTO_IS_NULL_SHORT_LINK_KEY, fullShortUrl), "-", 30, TimeUnit.MINUTES);
                jumpNotFound(request, response, fullShortUrl, originalLink);
                return;
            }

            // 构建短链接跳转缓存 并设置有效期
            stringRedisTemplate.opsForValue().set(String.format(GOTO_SHORT_LINK_KEY, fullShortUrl), shortLinkDO.getOriginUrl(),
                    LinkUtil.getLinkCacheValidTime(shortLinkDO.getValidDate()), TimeUnit.MILLISECONDS
            );
            // 监控统计
            ShortLinkStatsRecordDTO statsRecord = shortLinkStatsService.buildLinkStatsRecordAndSetUser(shortLinkDO.getGid(), fullShortUrl, request, response);
            shortLinkStatsService.shortLinkStats(statsRecord);
            // 浏览器302重定向URL
            jumpLink(request, response, fullShortUrl, shortLinkDO.getOriginUrl());

        } finally {
            lock.unlock();
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam) {

        // 验证白名单
        verificationWhitelist(requestParam.getOriginUrl());

        // 获取域名
        String domain = Objects.isNull(requestParam.getDomain()) ? NetUtils.removalProtocol(defaultShortLinkDomain) : NetUtils.removalProtocol(requestParam.getDomain());
        // 生成的短链接url后缀
        String shortUri = generateSuffix(requestParam);
        // 生成的短链接url
        String fullShortUrl = StrBuilder.create(domain).append(URL_SPLIT).append(shortUri).toString();

        // 短链接实体数据
        ShortLinkDO shortLinkDO = ShortLinkDO.builder()
                .gid(requestParam.getGid())
                .originUrl(requestParam.getOriginUrl())
                .domain(domain)
                .shortUri(shortUri)
                .fullShortUrl(fullShortUrl)
                .createdType(requestParam.getCreatedType())
                .validDateType(requestParam.getValidDateType())
                .validDate(requestParam.getValidDate())
                .describe(requestParam.getDescribe())
                .favicon(getFaviconByUrl(requestParam.getOriginUrl()))
                .title(getTitleByUrl(requestParam.getOriginUrl()))
                .totalPv(0)
                .totalUv(0)
                .totalUip(0)
                .clickNum(0)
                .enableStatus(0)
                .delTime(0L)
                .build();
        // 短链接跳转实体
        ShortLinkGotoDO shortLinkGotoDO = ShortLinkGotoDO.builder()
                .gid(requestParam.getGid())
                .fullShortUrl(fullShortUrl)
                .build();
        try {
            // 插入短链接实体数据
            int insert = baseMapper.insert(shortLinkDO);
            if (insert < 1) {
                throw new ServiceException(SHORT_LINK_SAVE_ERROR);
            }
            // 插入短链接跳转实体数据
            int insertShortLinkGoTo = shortLinkGotoMapper.insert(shortLinkGotoDO);
            if (insertShortLinkGoTo < 1) {
                throw new ServiceException(SHORT_LINK_GOTO_SAVE_ERROR);
            }
        } catch (DuplicateKeyException ex) {
            // 完整短链接重复错误
            if (!Objects.isNull(baseMapper.selectOne(Wrappers.lambdaQuery(ShortLinkDO.class).eq(ShortLinkDO::getFullShortUrl, fullShortUrl)))) {
                log.error("短链接：{} 重复入库，ex：{}", fullShortUrl, ex.getMessage());
                throw new ServiceException(SHORT_LINK_GENERATE_REPEAT_ERROR);
            }
        }

        // 完整短链接 加入布隆过滤器中
        shortUriCreateCachePenetrationBloomFilter.add(fullShortUrl);

        // 创建短链接时 进行缓存预热
        long linkCacheValidTime = LinkUtil.getLinkCacheValidTime(shortLinkDO.getValidDate());
        if (linkCacheValidTime > 0 ){
            // 创建短链接时候没有过期
            stringRedisTemplate.opsForValue().set(String.format(GOTO_SHORT_LINK_KEY, fullShortUrl), shortLinkDO.getOriginUrl(),
                    linkCacheValidTime, TimeUnit.MILLISECONDS
            );
        }else {
            // 创建短链接时已经过期
            stringRedisTemplate.opsForValue().set(String.format(GOTO_IS_NULL_SHORT_LINK_KEY, fullShortUrl), "-", 30, TimeUnit.MINUTES);
        }

        // 返回 ShortLinkCreateRespDTO 对象
        return ShortLinkCreateRespDTO.builder()
                .gid(requestParam.getGid())
                .originUrl(requestParam.getOriginUrl())
                .fullShortUrl(HTTP + fullShortUrl)
                .build();
    }

    @Override
    public ShortLinkBatchCreateRespDTO batchCreateShortLink(ShortLinkBatchCreateReqDTO requestParam) {

        // 原始链接集合
        List<String> originUrls = requestParam.getOriginUrls();
        // 原始链接描述集合
        List<String> describes = requestParam.getDescribes();

        // 批量创建短链接 参数校验
        if (originUrls.isEmpty() || describes.isEmpty() || originUrls.size() != describes.size()){
            throw new ServiceException(SHORT_LINK_PARAM_ERROR);
        }

        // 遍历原始链接和原始链接描述
        List<ShortLinkBaseInfoRespDTO> result = new ArrayList<>();
        for (int i = 0; i < originUrls.size(); i++) {
            // 创建短链接请求实体
            ShortLinkCreateReqDTO shortLinkCreateReqDTO = BeanUtil.toBean(requestParam, ShortLinkCreateReqDTO.class);
            shortLinkCreateReqDTO.setOriginUrl(originUrls.get(i));
            shortLinkCreateReqDTO.setDescribe(describes.get(i));

            // for 循环中捕获异常不影响其他短链接创建
            try {
                ShortLinkCreateRespDTO shortLink = createShortLink(shortLinkCreateReqDTO);
                result.add(ShortLinkBaseInfoRespDTO.builder()
                        .fullShortUrl(shortLink.getFullShortUrl())
                        .originUrl(shortLink.getOriginUrl())
                        .describe(describes.get(i))
                        .build()
                );
            } catch (Throwable ex) {
                log.error("[批量创建短链接失败]，原始参数：{}", originUrls.get(i));
            }
        }

        // 返回结果
        return ShortLinkBatchCreateRespDTO.builder()
                .total(result.size())
                .baseLinkInfos(result)
                .build();
    }

    @Override
    @Transactional
    public Boolean updateShortLink(ShortLinkUpdateReqDTO requestParam) {

        // 验证白名单
        verificationWhitelist(requestParam.getOriginUrl());

        // TODO fullShortUrl 暂不修改
        String fullShortUrl = NetUtils.removalProtocol(requestParam.getFullShortUrl());

        // 查询布隆过滤器短链接分组中是否存在该短链接
        if (!shortUriCreateCachePenetrationBloomFilter.contains(fullShortUrl)) {
            throw new ServiceException(SHORT_LINK_NOT_FOUND_ERROR);
        }

        // 查询短链接分组中是否存在该短链接
        LambdaQueryWrapper<ShortLinkDO> queryWrapper = Wrappers.lambdaQuery(ShortLinkDO.class)
                .eq(ShortLinkDO::getGid, requestParam.getOriginGid())
                .eq(ShortLinkDO::getFullShortUrl, fullShortUrl)
                .eq(ShortLinkDO::getEnableStatus, 0);
        ShortLinkDO hasShortLinkDO = baseMapper.selectOne(queryWrapper);
        if (Objects.isNull(hasShortLinkDO)){
            throw new ServiceException(SHORT_LINK_NOT_FOUND_ERROR);
        }

        // 判断是否修改分组 没有修改分组
        if (Objects.equals(requestParam.getGid(), hasShortLinkDO.getGid())){

            // 更新条件
            LambdaUpdateWrapper<ShortLinkDO> updateWrapper = Wrappers.lambdaUpdate(ShortLinkDO.class)
                    .eq(ShortLinkDO::getGid, hasShortLinkDO.getGid())
                    .eq(ShortLinkDO::getFullShortUrl, hasShortLinkDO.getFullShortUrl())
                    .eq(ShortLinkDO::getEnableStatus, 0)
                    .eq(ShortLinkDO::getDelTime, 0L);
            ShortLinkDO.ShortLinkDOBuilder builder = ShortLinkDO.builder();
            // 判断是否修改过跳转的链接 修改过跳转的短链接
            if (!Objects.equals(requestParam.getOriginUrl(), hasShortLinkDO.getOriginUrl())){
                builder.originUrl(requestParam.getOriginUrl())
                        .favicon(getFaviconByUrl(requestParam.getOriginUrl()))
                        .title(getTitleByUrl(requestParam.getOriginUrl()));
            }
            ShortLinkDO shortLinkDO = builder
                    .describe(requestParam.getDescribe())
                    .validDateType(requestParam.getValidDateType())
                    .validDate(requestParam.getValidDate())
                    .build();
            // 修改短链接信息
            baseMapper.update(shortLinkDO, updateWrapper);

            // 删除缓存
            stringRedisTemplate.delete(String.format(GOTO_SHORT_LINK_KEY, fullShortUrl));
            stringRedisTemplate.delete(String.format(GOTO_IS_NULL_SHORT_LINK_KEY, fullShortUrl));

            return true;
        }

        // ===============================================================需要修改分组
        // redisson分布式写锁
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(String.format(LOCK_GID_UPDATE_KEY, fullShortUrl));
        RLock writeLock = readWriteLock.writeLock();
        if (!writeLock.tryLock()) {
            throw new ServiceException(SHORT_LINK_IS_VISITED_ERROR);
        }

        try {
            // ====================================短链接表
            // 删除之前的短链接信息
            baseMapper.delByGidAndFullShortUrl(hasShortLinkDO.getGid(), hasShortLinkDO.getFullShortUrl(), System.currentTimeMillis());
            // 重新插入短链接信息
            ShortLinkDO shortLinkDO = ShortLinkDO.builder()
                    .gid(requestParam.getGid())
                    .originUrl(requestParam.getOriginUrl())
                    .domain(hasShortLinkDO.getDomain())
                    .shortUri(hasShortLinkDO.getShortUri())
                    .fullShortUrl(hasShortLinkDO.getFullShortUrl())
                    .createdType(hasShortLinkDO.getCreatedType())
                    .validDateType(requestParam.getValidDateType())
                    .validDate(requestParam.getValidDate())
                    .describe(requestParam.getDescribe())
                    .favicon(getFaviconByUrl(requestParam.getOriginUrl()))
                    .title(getTitleByUrl(requestParam.getOriginUrl()))
                    .enableStatus(hasShortLinkDO.getEnableStatus())
                    .clickNum(hasShortLinkDO.getClickNum())
                    .totalPv(hasShortLinkDO.getTotalPv())
                    .totalUv(hasShortLinkDO.getTotalUv())
                    .totalUip(hasShortLinkDO.getTotalUip())
                    .todayPv(hasShortLinkDO.getTodayPv())
                    .totalPv(hasShortLinkDO.getTotalPv())
                    .todayUip(hasShortLinkDO.getTodayUip())
                    .delTime(0L)
                    .build();
            shortLinkMapper.insert(shortLinkDO);

            // ====================================短链接跳转表
            // 查询
            LambdaQueryWrapper<ShortLinkGotoDO> linkGotoQueryWrapper = Wrappers.lambdaQuery(ShortLinkGotoDO.class)
                    .eq(ShortLinkGotoDO::getGid, hasShortLinkDO.getGid())
                    .eq(ShortLinkGotoDO::getFullShortUrl, hasShortLinkDO.getFullShortUrl());
            ShortLinkGotoDO shortLinkGotoDO = shortLinkGotoMapper.selectOne(linkGotoQueryWrapper);
            // 删除
            shortLinkGotoMapper.delete(linkGotoQueryWrapper);
            // 添加
            shortLinkGotoDO.setGid(requestParam.getGid());
            shortLinkGotoMapper.insert(shortLinkGotoDO);


            // =====================================监控数据更新
            // 1.短链接基础访问监控
            LambdaQueryWrapper<LinkAccessStatsDO> linkAccessStatsQueryWrapper = Wrappers.lambdaQuery(LinkAccessStatsDO.class)
                    .eq(LinkAccessStatsDO::getGid, hasShortLinkDO.getGid())
                    .eq(LinkAccessStatsDO::getFullShortUrl, hasShortLinkDO.getFullShortUrl())
                    .eq(LinkAccessStatsDO::getDelFlag, 0);
            List<LinkAccessStatsDO> linkAccessStatsDOList = linkAccessStatsMapper.selectList(linkAccessStatsQueryWrapper);
            if (CollUtil.isNotEmpty(linkAccessStatsDOList)) {
                linkAccessStatsMapper.deleteByGidAndFullShortUrl(hasShortLinkDO.getGid(), hasShortLinkDO.getFullShortUrl());
                linkAccessStatsDOList.forEach(item -> {
                    item.setId(IdUtil.getSnowflake(1, 1).nextId());
                    item.setGid(requestParam.getGid());
                });
                linkAccessStatsService.saveBatch(linkAccessStatsDOList);
            }

            // 2.短链接今日统计
            LambdaQueryWrapper<LinkStatsTodayDO> linkStatsTodayQueryWrapper = Wrappers.lambdaQuery(LinkStatsTodayDO.class)
                    .eq(LinkStatsTodayDO::getGid, hasShortLinkDO.getGid())
                    .eq(LinkStatsTodayDO::getFullShortUrl, hasShortLinkDO.getFullShortUrl())
                    .eq(LinkStatsTodayDO::getDelFlag, 0);
            List<LinkStatsTodayDO> linkStatsTodayDOList = linkStatsTodayMapper.selectList(linkStatsTodayQueryWrapper);
            if (CollUtil.isNotEmpty(linkStatsTodayDOList)) {
                linkStatsTodayMapper.deleteByGidAndFullShortUrl(hasShortLinkDO.getGid(), hasShortLinkDO.getFullShortUrl());
                linkStatsTodayDOList.forEach(item -> {
                    item.setId(IdUtil.getSnowflake(1, 1).nextId());
                    item.setGid(requestParam.getGid());
                });
                linkStatsTodayService.saveBatch(linkStatsTodayDOList);
            }

            // 3.短链接地区统计
            LambdaQueryWrapper<LinkLocaleStatsDO> linkLocaleStatsQueryWrapper = Wrappers.lambdaQuery(LinkLocaleStatsDO.class)
                    .eq(LinkLocaleStatsDO::getGid, hasShortLinkDO.getGid())
                    .eq(LinkLocaleStatsDO::getFullShortUrl, hasShortLinkDO.getFullShortUrl())
                    .eq(LinkLocaleStatsDO::getDelFlag, 0);
            List<LinkLocaleStatsDO> linkLocaleStatsDOList = linkLocaleStatsMapper.selectList(linkLocaleStatsQueryWrapper);
            if (CollUtil.isNotEmpty(linkLocaleStatsDOList)) {
                linkLocaleStatsMapper.deleteByGidAndFullShortUrl(hasShortLinkDO.getGid(), hasShortLinkDO.getFullShortUrl());
                linkLocaleStatsDOList.forEach(item -> {
                    item.setId(IdUtil.getSnowflake(1, 1).nextId());
                    item.setGid(requestParam.getGid());
                });
                linkLocaleStatsService.saveBatch(linkLocaleStatsDOList);
            }

            // 4.短链接浏览器访问
            LambdaQueryWrapper<LinkBrowserStatsDO> linkBrowserStatsQueryWrapper = Wrappers.lambdaQuery(LinkBrowserStatsDO.class)
                    .eq(LinkBrowserStatsDO::getGid, hasShortLinkDO.getGid())
                    .eq(LinkBrowserStatsDO::getFullShortUrl, hasShortLinkDO.getFullShortUrl())
                    .eq(LinkBrowserStatsDO::getDelFlag, 0);
            List<LinkBrowserStatsDO> linkBrowserStatsDOList = linkBrowserStatsMapper.selectList(linkBrowserStatsQueryWrapper);
            if (CollUtil.isNotEmpty(linkBrowserStatsDOList)) {
                linkBrowserStatsMapper.deleteByGidAndFullShortUrl(hasShortLinkDO.getGid(), hasShortLinkDO.getFullShortUrl());
                linkBrowserStatsDOList.forEach(item -> {
                    item.setId(IdUtil.getSnowflake(1, 1).nextId());
                    item.setGid(requestParam.getGid());
                });
                linkBrowserStatsService.saveBatch(linkBrowserStatsDOList);
            }

            // 5.操作系统统计访问
            LambdaQueryWrapper<LinkOsStatsDO> linkOsStatsQueryWrapper = Wrappers.lambdaQuery(LinkOsStatsDO.class)
                    .eq(LinkOsStatsDO::getGid, hasShortLinkDO.getGid())
                    .eq(LinkOsStatsDO::getFullShortUrl, hasShortLinkDO.getFullShortUrl())
                    .eq(LinkOsStatsDO::getDelFlag, 0);
            List<LinkOsStatsDO> linkOsStatsDOList = linkOsStatsMapper.selectList(linkOsStatsQueryWrapper);
            if (CollUtil.isNotEmpty(linkOsStatsDOList)) {
                linkOsStatsMapper.deleteByGidAndFullShortUrl(hasShortLinkDO.getGid(), hasShortLinkDO.getFullShortUrl());
                linkOsStatsDOList.forEach(item -> {
                    item.setId(IdUtil.getSnowflake(1, 1).nextId());
                    item.setGid(requestParam.getGid());
                });
                linkOsStatsService.saveBatch(linkOsStatsDOList);
            }

            // 6.短链接设备访问
            LambdaQueryWrapper<LinkDeviceStatsDO> linkDeviceStatsQueryWrapper = Wrappers.lambdaQuery(LinkDeviceStatsDO.class)
                    .eq(LinkDeviceStatsDO::getGid, hasShortLinkDO.getGid())
                    .eq(LinkDeviceStatsDO::getFullShortUrl, hasShortLinkDO.getFullShortUrl())
                    .eq(LinkDeviceStatsDO::getDelFlag, 0);
            List<LinkDeviceStatsDO> linkDeviceStatsDOList = linkDeviceStatsMapper.selectList(linkDeviceStatsQueryWrapper);
            if (CollUtil.isNotEmpty(linkDeviceStatsDOList)) {
                linkDeviceStatsMapper.deleteByGidAndFullShortUrl(hasShortLinkDO.getGid(), hasShortLinkDO.getFullShortUrl());
                linkDeviceStatsDOList.forEach(item -> {
                    item.setId(IdUtil.getSnowflake(1, 1).nextId());
                    item.setGid(requestParam.getGid());
                });
                linkDeviceStatsService.saveBatch(linkDeviceStatsDOList);
            }

            // 7.短链接网络访问
            LambdaQueryWrapper<LinkNetworkStatsDO> linkNetworkStatsQueryWrapper = Wrappers.lambdaQuery(LinkNetworkStatsDO.class)
                    .eq(LinkNetworkStatsDO::getGid, hasShortLinkDO.getGid())
                    .eq(LinkNetworkStatsDO::getFullShortUrl, hasShortLinkDO.getFullShortUrl())
                    .eq(LinkNetworkStatsDO::getDelFlag, 0);
            List<LinkNetworkStatsDO> linkNetworkStatsDOList = linkNetworkStatsMapper.selectList(linkNetworkStatsQueryWrapper);
            if (CollUtil.isNotEmpty(linkNetworkStatsDOList)) {
                linkNetworkStatsMapper.deleteByGidAndFullShortUrl(hasShortLinkDO.getGid(), hasShortLinkDO.getFullShortUrl());
                linkNetworkStatsDOList.forEach(item -> {
                    item.setId(IdUtil.getSnowflake(1, 1).nextId());
                    item.setGid(requestParam.getGid());
                });
                linkNetworkStatsService.saveBatch(linkNetworkStatsDOList);
            }

            // 8.短链接访问日志监控
            LambdaQueryWrapper<LinkAccessLogsDO> linkAccessLogsQueryWrapper = Wrappers.lambdaQuery(LinkAccessLogsDO.class)
                    .eq(LinkAccessLogsDO::getGid, hasShortLinkDO.getGid())
                    .eq(LinkAccessLogsDO::getFullShortUrl, hasShortLinkDO.getFullShortUrl())
                    .eq(LinkAccessLogsDO::getDelFlag, 0);
            List<LinkAccessLogsDO> linkAccessLogsDOList = linkAccessLogsMapper.selectList(linkAccessLogsQueryWrapper);
            if (CollUtil.isNotEmpty(linkAccessLogsDOList)) {
                linkAccessLogsMapper.delete(linkAccessLogsQueryWrapper);
                linkAccessLogsDOList.forEach(item -> {
                    item.setId(IdUtil.getSnowflake(1, 1).nextId());
                    item.setGid(requestParam.getGid());
                });
                linkAccessLogsService.saveBatch(linkAccessLogsDOList);
            }
        } finally {
            // 释放锁
            writeLock.unlock();
        }

        // 删除缓存
        stringRedisTemplate.delete(String.format(GOTO_SHORT_LINK_KEY, fullShortUrl));
        stringRedisTemplate.delete(String.format(GOTO_IS_NULL_SHORT_LINK_KEY, fullShortUrl));

        return true;
    }

    /**
     * 生成短链接后缀
     */
    private String generateSuffix(ShortLinkCreateReqDTO requestParam) {
        String shortUri;
        int customGenerateCount = 0;
        while (true) {
            // 调用生成的次数 每次加1 最多生成10次
            customGenerateCount++;
            if (customGenerateCount >= 10) {
                throw new ServiceException(SHORT_LINK_GENERATE_ERROR);
            }

            // 生成短链接后缀 原始链接 加入 时间戳(随机盐) 之后去调用 短链接生产算法 防止重复 <去除时间戳，因为在高并发情况下，时间戳可能重复，以至于短链接重复>
            // 生成短链接后缀 原始链接 加入 UUID(随机盐) 之后去调用 短链接生产算法 防止重复
            shortUri = HashUtils.hashToBase62(StrBuilder.create(requestParam.getOriginUrl()).append(UUID.randomUUID()).toString());
            // 完整短链接
            String fullShortUrl = StrBuilder.create(Objects.isNull(requestParam.getDomain()) ? NetUtils.removalProtocol(defaultShortLinkDomain) : NetUtils.removalProtocol(requestParam.getDomain())).append(URL_SPLIT).append(shortUri).toString();

            // 完整短链接 布隆过滤器中没有则直接返回
            if (!shortUriCreateCachePenetrationBloomFilter.contains(fullShortUrl)) {
                return shortUri;
            }
        }
    }

    /**
     * 短链接跳转
     *
     * @param request      ServletRequest
     * @param response     ServletResponse
     * @param fullShortUrl 完整短链接
     * @param originalLink 原始链接
     */
    @SneakyThrows
    private void jumpLink(ServletRequest request, ServletResponse response, String fullShortUrl, String originalLink) {
        try {
            // 浏览器302重定向URL
            ((HttpServletResponse) response).sendRedirect(originalLink);
        } catch (Exception e) {
            log.error(fullShortUrl + " ===> " + originalLink + " 跳转失败");
            throw new ServiceException(SHORT_LINK_JUMP_ERROR);
        }
    }

    /**
     * 短链接跳转失败页面
     *
     * @param request      ServletRequest
     * @param response     ServletResponse
     * @param fullShortUrl 完整短链接
     * @param originalLink 原始链接
     */
    @SneakyThrows
    private void jumpNotFound(ServletRequest request, ServletResponse response, String fullShortUrl, String originalLink) {
        ((HttpServletResponse) response).sendRedirect("/page/notfound");
        if (StringUtils.isBlank(originalLink)) {
            log.info(fullShortUrl + " <===> " + "跳转链接失败，短链接系统中不存在");
        } else {
            log.info(fullShortUrl + " ===> " + originalLink + "跳转链接失败，短链接系统中不存在");
        }
    }

    /**
     * 验证白名单
     *
     * @param originUrl 原始链接
     */
    private void verificationWhitelist(String originUrl) {

        // 是否开启 没有配置或者为False表示没开启
        Boolean enable = gotoDomainWhiteListConfiguration.getEnable();
        if (enable == null || !enable) {
            return;
        }

        // 获取域名并检查是否为空
        String domain = LinkUtil.extractDomain(originUrl);
        if (StrUtil.isBlank(domain)) {
            throw new ServiceException(SHORT_LINK_INPUT_ERROR);
        }

        // 检查白名单
        List<String> details = gotoDomainWhiteListConfiguration.getDetails();
        if (!details.contains(domain)) {
            throw new ServiceException("演示环境为避免恶意攻击，请生成以下网站跳转链接：" + gotoDomainWhiteListConfiguration.getNames());
        }
    }

    @SneakyThrows
    @Override
    public String getFaviconByUrl(String url) {
        // 发送请求获取连接
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
            // 获取网页的Favicon图标
            Element faviconLink = Jsoup.connect(url).get().select("link[rel~=(?i)^(shortcut )?icon]").first();
            if (!Objects.isNull(faviconLink)) {
                String favicon = faviconLink.attr("abs:href");
                log.info("获取网页的favicon图标成功， [URL:{}] [favicon:{}]", url, favicon);
                return favicon;
            }
        }
        log.error("获取网页的favicon图标失败，URL:{}", url);
        return null;
    }

    @SneakyThrows
    @Override
    public String getTitleByUrl(String url) {
        // 发送请求获取连接
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
            // 获取网页的Title标题
            String title = Jsoup.connect(url).get().title();
            log.info("获取网页的Title成功， [URL:{}] [favicon:{}]", url, title);
            return title;
        }
        log.error("获取网页的Title失败，URL:{}", url);
        return null;
    }

    @Override
    public IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam) {
        // 查询page数据 带统计数据
        IPage<ShortLinkDO> resultPage = baseMapper.pageLink(requestParam);
        // page记录类型转化
        return resultPage.convert((shortLinkDO) -> {
            ShortLinkPageRespDTO bean = BeanUtil.toBean(shortLinkDO, ShortLinkPageRespDTO.class);
            bean.setFullShortUrl(HTTP + bean.getFullShortUrl());
            return bean;
        });
    }

    @Override
    public List<ShortLinkGroupCountQueryRespDTO> listGroupShortLinkCount(List<String> requestParam) {
        // 查询条件
        QueryWrapper<ShortLinkDO> queryWrapper = Wrappers.query(new ShortLinkDO())
                .select("gid as gid, count(*) as shortLinkCount")
                .in("gid", requestParam)
                .eq("enable_status", 0)
                .eq("del_time", 0L)
                .groupBy("gid");
        // 查询记录
        List<Map<String, Object>> shortLinkDOList = baseMapper.selectMaps(queryWrapper);
        // 返回数据
        return BeanUtil.copyToList(shortLinkDOList, ShortLinkGroupCountQueryRespDTO.class);
    }

    @Override
    public Boolean deleteGroupShortLink(String gid) {
        // 查询条件
        LambdaQueryWrapper<ShortLinkDO> hasShortLinkQueryWrapper = Wrappers.lambdaQuery(ShortLinkDO.class)
                .eq(ShortLinkDO::getGid, gid)
                .eq(ShortLinkDO::getEnableStatus, 0)
                .eq(ShortLinkDO::getDelTime, 0L); // 存在启用的短链接
        List<ShortLinkDO> hasShortLinkList = baseMapper.selectList(hasShortLinkQueryWrapper);
        if (!CollectionUtils.isEmpty(hasShortLinkList)) {
            throw new ServiceException(GROUP_HAS_SHORT_LINK);
        }

        // 查询条件
        LambdaQueryWrapper<ShortLinkDO> hasRecycleBinShortLinkQueryWrapper = Wrappers.lambdaQuery(ShortLinkDO.class)
                .eq(ShortLinkDO::getGid, gid)
                .eq(ShortLinkDO::getEnableStatus, 1)
                .eq(ShortLinkDO::getDelTime, 0L); // 存在未启用，即在回收站中的短链接
        List<ShortLinkDO> hasRecycleBinShortLinkLinkList = baseMapper.selectList(hasRecycleBinShortLinkQueryWrapper);
        if (!CollectionUtils.isEmpty(hasRecycleBinShortLinkLinkList)) {
            throw new ServiceException(GROUP_HAS_RECYCLE_BIN_SHORT_LINK_ERROR);
        }

        return true;
    }

}