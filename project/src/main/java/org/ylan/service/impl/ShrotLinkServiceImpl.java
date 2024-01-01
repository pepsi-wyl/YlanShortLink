package org.ylan.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.text.StrBuilder;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
import org.redisson.api.RedissonClient;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylan.common.convention.enums.VailDateTypeEnum;
import org.ylan.common.convention.exception.ServiceException;
import org.ylan.mapper.ShortLinkGotoMapper;
import org.ylan.mapper.ShortLinkMapper;
import org.ylan.model.dto.req.ShortLinkCreateReqDTO;
import org.ylan.model.dto.req.ShortLinkPageReqDTO;
import org.ylan.model.dto.resp.ShortLinkCreateRespDTO;
import org.ylan.model.dto.resp.ShortLinkGroupCountQueryRespDTO;
import org.ylan.model.dto.resp.ShortLinkPageRespDTO;
import org.ylan.model.entity.ShortLinkDO;
import org.ylan.model.entity.ShortLinkGotoDO;
import org.ylan.service.ShortLinkService;
import org.ylan.utils.HashUtils;
import org.ylan.utils.LinkUtil;
import org.ylan.utils.NetUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.ylan.common.constant.NetConstant.HTTP;
import static org.ylan.common.constant.NetConstant.URL_SPLIT;
import static org.ylan.common.constant.RedisCacheConstant.*;
import static org.ylan.common.convention.enums.ShortLinkErrorCodeEnum.*;

/**
 * 短链接接口实现层
 *
 * @author ylan
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ShrotLinkServiceImpl extends ServiceImpl<ShortLinkMapper, ShortLinkDO> implements ShortLinkService {

    /**
     *  防止短链接创建查询数据库的布隆过滤器
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

    @SneakyThrows
    @Override
    public void restoreUrl(String shortUri, ServletRequest request, ServletResponse response) {

        String domain = request.getServerName();
        String fullShortUrl =  domain + URL_SPLIT + shortUri;

        // 利用 布隆过滤器 进行过滤 ，不存在的FullShortUrl 直接过滤 并跳转不存在
        boolean bLoomFilterContain = shortUriCreateCachePenetrationBloomFilter.contains(fullShortUrl);
        if (!bLoomFilterContain){
            jumpNotFound(request, response ,fullShortUrl, null);
            return;
        }

        // 查询缓存 判断缓存中是否存在 要跳转的FullShortUrl，存在直接返回
        String originalLink = stringRedisTemplate.opsForValue().get(String.format(GOTO_SHORT_LINK_KEY, fullShortUrl));
        if (StringUtils.isNotBlank(originalLink)){
            // 浏览器302重定向URL
            jumpLink(request, response, fullShortUrl, originalLink);
            return;
        }

        // 查询缓存 判断缓存中是否存在 Null值FullShortUrl，存在直接返回，避免查询数据库 造成缓存穿透 并跳转不存在
        String gotoIsNullShortLink = stringRedisTemplate.opsForValue().get(String.format(GOTO_IS_NULL_SHORT_LINK_KEY, fullShortUrl));
        if (StringUtils.isNotBlank(gotoIsNullShortLink)){
            jumpNotFound(request, response ,fullShortUrl, originalLink);
            return;
        }

        // 分布式锁锁住相同FullShortUrl的请求，只能由一个去构建缓存
        RLock lock = redissonClient.getLock(String.format(LOCK_GOTO_SHORT_LINK_KEY, fullShortUrl));
        lock.lock();
        try {
            // 双重检查 检查是否有请求构建跳转的FullShortUrl缓存成功
            originalLink = stringRedisTemplate.opsForValue().get(String.format(GOTO_SHORT_LINK_KEY, fullShortUrl));
            if (StringUtils.isNotBlank(originalLink)){
                // 浏览器302重定向URL
                jumpLink(request, response, fullShortUrl, originalLink);
                return;
            }

            // 双重检查 检查是否有请求构建构建Null值FullShortUrl缓存成功
            gotoIsNullShortLink = stringRedisTemplate.opsForValue().get(String.format(GOTO_IS_NULL_SHORT_LINK_KEY, fullShortUrl));
            if (StringUtils.isNotBlank(gotoIsNullShortLink)){
                jumpNotFound(request, response ,fullShortUrl, originalLink);
                return;
            }

            // 根据短链接查询GoTo路由表
            LambdaQueryWrapper<ShortLinkGotoDO> linkGotoQueryWrapper =
                    Wrappers.lambdaQuery(ShortLinkGotoDO.class).eq(ShortLinkGotoDO::getFullShortUrl, fullShortUrl);
            ShortLinkGotoDO shortLinkGotoDO = shortLinkGotoMapper.selectOne(linkGotoQueryWrapper);
            // 如果路由表中不存在则直接 构建Null值FullShortUrl 缓存 30分钟 并跳转不存在
            if (Objects.isNull(shortLinkGotoDO)){
                stringRedisTemplate.opsForValue().set(String.format(GOTO_IS_NULL_SHORT_LINK_KEY, fullShortUrl), "-", 30, TimeUnit.MINUTES);
                jumpNotFound(request, response ,fullShortUrl, originalLink);
                return;
            }

            // 查询短链接表
            LambdaQueryWrapper<ShortLinkDO> shortLinkQueryWrapper = Wrappers.lambdaQuery(ShortLinkDO.class)
                    .eq(ShortLinkDO::getGid, shortLinkGotoDO.getGid())
                    .eq(ShortLinkDO::getFullShortUrl, fullShortUrl)
                    .eq(ShortLinkDO::getEnableStatus, 0);
            ShortLinkDO shortLinkDO = baseMapper.selectOne(shortLinkQueryWrapper);
            // 如果短链接表不存在 或者 短链接有效期过期 构建Null值FullShortUrl 缓存 30分钟 并跳转不存在
            if (Objects.isNull(shortLinkDO) || (VailDateTypeEnum.CUSTOM.getType().equals(shortLinkDO.getValidDateType()) && shortLinkDO.getValidDate().before(new Date()))){
                stringRedisTemplate.opsForValue().set(String.format(GOTO_IS_NULL_SHORT_LINK_KEY, fullShortUrl), "-", 30, TimeUnit.MINUTES);
                jumpNotFound(request, response ,fullShortUrl, originalLink);
                return;
            }

            // 构建短链接跳转缓存 并设置有效期
            stringRedisTemplate.opsForValue().set(String.format(GOTO_SHORT_LINK_KEY, fullShortUrl), shortLinkDO.getOriginUrl(),
                    LinkUtil.getLinkCacheValidTime(shortLinkDO.getValidDate()), TimeUnit.MILLISECONDS
            );
            // 浏览器302重定向URL
            jumpLink(request, response, fullShortUrl, shortLinkDO.getOriginUrl());

        }finally {
            lock.lock();
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam) {

        // 生成的短链接url后缀
        String shortUri = generateSuffix(requestParam);
        // 生成的短链接url
        String fullShortUrl = StrBuilder.create(NetUtils.removalProtocol(requestParam.getDomain())).append(URL_SPLIT).append(shortUri).toString();

        // 短链接实体数据
        ShortLinkDO shortLinkDO = ShortLinkDO.builder()
                .gid(requestParam.getGid())
                .originUrl(requestParam.getOriginUrl())
                .domain(NetUtils.removalProtocol(requestParam.getDomain()))
                .shortUri(shortUri)
                .fullShortUrl(fullShortUrl)
                .createdType(requestParam.getCreatedType())
                .validDateType(requestParam.getValidDateType())
                .validDate(requestParam.getValidDate())
                .describe(requestParam.getDescribe())
                .favicon(getFaviconByUrl(requestParam.getOriginUrl()))
                .title(getTitleByUrl(requestParam.getOriginUrl()))
                .enableStatus(0)
                .build();
        // 短链接跳转实体
        ShortLinkGotoDO shortLinkGotoDO = ShortLinkGotoDO.builder()
                .gid(requestParam.getGid())
                .fullShortUrl(fullShortUrl)
                .build();
        try {
            // 插入短链接实体数据
            int insert = baseMapper.insert(shortLinkDO);
            if (insert < 1){
                throw new ServiceException(SHORT_LINK_SAVE_ERROR);
            }
            // 插入短链接跳转实体数据
            int insertShortLinkGoTo = shortLinkGotoMapper.insert(shortLinkGotoDO);
            if (insertShortLinkGoTo < 1){
                throw new ServiceException(SHORT_LINK_GOTO_SAVE_ERROR);
            }
        } catch (DuplicateKeyException ex) {
            // 完整短链接重复错误
            if (!Objects.isNull(baseMapper.selectOne(Wrappers.lambdaQuery(ShortLinkDO.class).eq(ShortLinkDO::getFullShortUrl, fullShortUrl)))) {
                log.error("短链接：{} 重复入库，ex：{}", fullShortUrl,ex.getMessage());
                throw new ServiceException(SHORT_LINK_GENERATE_REPEAT_ERROR);
            }
        }

        // 完整短链接 加入布隆过滤器中
        shortUriCreateCachePenetrationBloomFilter.add(fullShortUrl);

        // 创建短链接时 进行缓存预热
        stringRedisTemplate.opsForValue().set(String.format(GOTO_SHORT_LINK_KEY, fullShortUrl), shortLinkDO.getOriginUrl(),
                LinkUtil.getLinkCacheValidTime(shortLinkDO.getValidDate()), TimeUnit.MILLISECONDS
        );

        // 返回 ShortLinkCreateRespDTO 对象
        return ShortLinkCreateRespDTO.builder()
                .gid(requestParam.getGid())
                .originUrl(requestParam.getOriginUrl())
                .fullShortUrl(HTTP + fullShortUrl)
                .build();
    }

    /**
     * 生成短链接后缀
     */
    private String generateSuffix(ShortLinkCreateReqDTO requestParam) {
        String shortUri;
        int customGenerateCount = 0;
        while (true) {
            // 调用生成的次数 每次加1 最多生成10次
            customGenerateCount ++;
            if (customGenerateCount >= 10) {
                throw new ServiceException(SHORT_LINK_GENERATE_ERROR);
            }

            // 生成短链接后缀 原始链接 加入 时间戳(随机盐) 之后去调用 短链接生产算法 防止重复 <去除时间戳，因为在高并发情况下，时间戳可能重复，以至于短链接重复>
            // 生成短链接后缀 原始链接 加入 UUID(随机盐) 之后去调用 短链接生产算法 防止重复
            shortUri = HashUtils.hashToBase62(StrBuilder.create(requestParam.getOriginUrl()).append(UUID.randomUUID()).toString());
            // 完整短链接
            String fullShortUrl = StrBuilder.create(NetUtils.removalProtocol(requestParam.getDomain())).append(URL_SPLIT).append(shortUri).toString();

            // 完整短链接 布隆过滤器中没有则直接返回
            if (!shortUriCreateCachePenetrationBloomFilter.contains(fullShortUrl)) {
                return shortUri;
            }
        }
    }

    /**
     * 短链接跳转
     *
     * @param request       ServletRequest
     * @param response      ServletResponse
     * @param fullShortUrl  完整短链接
     * @param originalLink  原始链接
     */
    @SneakyThrows
    private void jumpLink(ServletRequest request, ServletResponse response, String fullShortUrl, String originalLink){
        try {
            // 浏览器302重定向URL
            ((HttpServletResponse) response).sendRedirect(originalLink);
        }catch (Exception e){
            log.error(fullShortUrl + " ===> " +originalLink +" 跳转失败");
            throw new ServiceException(SHORT_LINK_JUMP_ERROR);
        }
    }

    /**
     * 短链接跳转失败页面
     *
     * @param request       ServletRequest
     * @param response      ServletResponse
     * @param fullShortUrl  完整短链接
     * @param originalLink  原始链接
     */
    @SneakyThrows
    private void jumpNotFound(ServletRequest request, ServletResponse response, String fullShortUrl, String originalLink){
        ((HttpServletResponse) response).sendRedirect("/page/notfound");
        if (StringUtils.isBlank(originalLink)){
            log.info(fullShortUrl + " <===> " + "跳转链接失败，短链接系统中不存在");
        }
        else {
            log.info(fullShortUrl + " ===> " +originalLink + "跳转链接失败，短链接系统中不存在");
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
        // 查询条件
        LambdaQueryWrapper<ShortLinkDO> queryWrapper = Wrappers.lambdaQuery(ShortLinkDO.class)
                .eq(ShortLinkDO::getGid, requestParam.getGid()) // gid
                .eq(ShortLinkDO::getEnableStatus, 0)       // 启用
                .orderByDesc(ShortLinkDO::getCreateTime);       // 创建时间降序排列
        // 查询page
        IPage<ShortLinkDO> resultPage = baseMapper.selectPage(requestParam, queryWrapper);

        // page记录类型转化
        return resultPage.convert((shortLinkDO)->{
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
                .groupBy("gid");
        // 查询记录
        List<Map<String, Object>> shortLinkDOList = baseMapper.selectMaps(queryWrapper);
        // 返回数据
        return BeanUtil.copyToList(shortLinkDOList, ShortLinkGroupCountQueryRespDTO.class);
    }

}