package org.ylan.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.ylan.mapper.*;
import org.ylan.model.entity.*;
import org.ylan.service.ShortLinkStatsService;
import org.ylan.utils.LinkUtil;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static org.ylan.common.constant.ApiConstant.*;
import static org.ylan.common.constant.ApiConstant.AMAP_RESP_ADCODE_EMPTY;
import static org.ylan.common.constant.NetConstant.URL_SPLIT;
import static org.ylan.common.constant.RedisCacheConstant.SHORT_LINK_STATS_UIP_PREFIX;
import static org.ylan.common.constant.RedisCacheConstant.SHORT_LINK_STATS_UV_PREFIX;
import static org.ylan.common.constant.ShortLinkStatsConstant.UV_STATS_COOKIE_NAME;
import static org.ylan.common.constant.ShortLinkStatsConstant.UV_STATS_COOKIE_TIME;

/**
 * 短链接监控服务接口实现层
 *
 * @author ylan
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ShortLinkStatsServiceImpl implements ShortLinkStatsService {

    /**
     * Redis缓存
     */
    private final StringRedisTemplate stringRedisTemplate;

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
     * AMAP URL
     */
    @Value("${short-link.stats.locale.amap-remote-url}")
    private String statsLocaleAmapRemoteUrl;

    /**
     * AMAP KEY
     */
    @Value("${short-link.stats.locale.amap-key}")
    private String statsLocaleAmapKey;

    //    @Async
    public void shortLinkStats(String gid, String fullShortUrl, ServletRequest request, ServletResponse response) {
        try {

            // 获取到客户端 cookies
            Cookie[] cookies = ((HttpServletRequest) request).getCookies();
            // UV Flag Atomic
            AtomicBoolean uvFlagAtomic = new AtomicBoolean();
            // UV Value Atomic
            AtomicReference<String> uvValueAtomic = new AtomicReference<>();

            Runnable addResponseCookieTask = () -> {
                // uvValue设置
                uvValueAtomic.set(cn.hutool.core.lang.UUID.fastUUID().toString());

                // 设置Cookie 1. uv-uvValue 2.过期时间30天 3.域 /shortUrl
                Cookie uvCookie = new Cookie(UV_STATS_COOKIE_NAME, uvValueAtomic.get());
                uvCookie.setMaxAge(UV_STATS_COOKIE_TIME);
                uvCookie.setPath(StrUtil.sub(fullShortUrl, fullShortUrl.indexOf(URL_SPLIT), fullShortUrl.length()));
                ((HttpServletResponse) response).addCookie(uvCookie);

                // Redis中添加set集合
                Long uvAdded = stringRedisTemplate.opsForSet().add(SHORT_LINK_STATS_UV_PREFIX + fullShortUrl, uvValueAtomic.get());
                // uvFlagAtomic 设置 根据添加的Set集合进行判断是否是第一次访问
                uvFlagAtomic.set(uvAdded != null && uvAdded > 0L);
            };

            if (ArrayUtil.isNotEmpty(cookies)) {
                Arrays.stream(cookies)
                        // 取第一个 Cookie 名为 UV_STATS_COOKIE_NAME 的 Cookie
                        .filter(cookie -> Objects.equals(cookie.getName(), UV_STATS_COOKIE_NAME))
                        .findFirst()
                        // 取 Cookie Value
                        .map(Cookie::getValue)
                        .ifPresentOrElse(uvValue -> {
                            // uvValue设置
                            uvValueAtomic.set(uvValue);
                            // Redis中添加Set集合
                            Long uvAdded = stringRedisTemplate.opsForSet().add(SHORT_LINK_STATS_UV_PREFIX + fullShortUrl, uvValue);
                            // uvFlagAtomic 设置 根据添加的Set集合进行判断是否锁第一次访问
                            uvFlagAtomic.set(uvAdded != null && uvAdded > 0L);
                        }, addResponseCookieTask);
            } else {
                // 该用户首次访问该链接并且cookies为空
                addResponseCookieTask.run();
            }


            // UIP Flag Atomic
            AtomicBoolean uipFlagAtomic = new AtomicBoolean();
            // 用户真实IP
            String remoteAddr = LinkUtil.getActualIp(((HttpServletRequest) request));
            // Redis中添加Set集合
            Long uipAdded = stringRedisTemplate.opsForSet().add(SHORT_LINK_STATS_UIP_PREFIX + fullShortUrl, remoteAddr);
            // uipFlagAtomic 设置 根据添加的Set集合进行判断是否锁第一次访问
            uipFlagAtomic.set(uipAdded != null && uipAdded > 0L);


            // 当前时间
            Date currentTime = new Date();

            // Gid不存在时候先查询GoTo表获取Gid
            if (StrUtil.isBlank(gid)) {
                LambdaQueryWrapper<ShortLinkGotoDO> queryWrapper =
                        Wrappers.lambdaQuery(ShortLinkGotoDO.class).eq(ShortLinkGotoDO::getFullShortUrl, fullShortUrl);
                ShortLinkGotoDO shortLinkGotoDO = shortLinkGotoMapper.selectOne(queryWrapper);
                gid = shortLinkGotoDO.getGid();
            }

            // 短链接基础访问监控数据准备
            LinkAccessStatsDO linkAccessStatsDO = LinkAccessStatsDO.builder()
                    .id(IdUtil.getSnowflake(1, 1).nextId())
                    .gid(gid)
                    .fullShortUrl(fullShortUrl)
                    .date(currentTime)
                    .hour(DateUtil.hour(currentTime, true))
                    .weekday(DateUtil.dayOfWeekEnum(currentTime).getIso8601Value())
                    .pv(1)                                  // PV
                    .uv(uvFlagAtomic.get() ? 1 : 0)         // UV
                    .uip(uipFlagAtomic.get() ? 1 : 0)       // UIP
                    .createTime(currentTime)
                    .updateTime(currentTime)
                    .delFlag(0)
                    .build();
            // 短链接基础访问监控插入数据
            linkAccessStatsMapper.shortLinkStats(linkAccessStatsDO);


            String actualProvince = null;
            String actualCity = null;
            String actualAdcode = null;
            // 准备高德地图API参数
            Map<String, Object> localeParamMap = new HashMap<>();
            localeParamMap.put(AMAP_KEY, statsLocaleAmapKey);
            localeParamMap.put(AMAP_IP, remoteAddr);
            // 发送Get请求 并解析为JSONObject 超时时间3000毫秒
            String localeResultStr = HttpUtil.get(statsLocaleAmapRemoteUrl, localeParamMap,3000);
            JSONObject localeResultObj = JSON.parseObject(localeResultStr);
            // 响应成功 返回码值为 AMAP_RESP_INFOCODE_SUCCESS
            String infoCode = localeResultObj.getString(AMAP_RESP_INFOCODE);
            if (StrUtil.isNotBlank(infoCode) && StrUtil.equals(infoCode, AMAP_RESP_INFOCODE_SUCCESS)) {

                // 解析响应JSONObject
                String province = localeResultObj.getString(AMAP_RESP_PROVINCE);
                String city = localeResultObj.getString(AMAP_RESP_CITY);
                String adcode = localeResultObj.getString(AMAP_RESP_ADCODE);
                // 判断解析到的信息 是否为空
                boolean provinceFlag = StrUtil.equals(province, AMAP_RESP_PROVINCE_EMPTY);
                boolean cityFlag = StrUtil.equals(city, AMAP_RESP_CITY_EMPTY);
                boolean adcodeFlag = StrUtil.equals(adcode, AMAP_RESP_ADCODE_EMPTY);
                // 短链接地区统计访问数据准备
                LinkLocaleStatsDO linkLocaleStatsDO = LinkLocaleStatsDO.builder()
                        .id(IdUtil.getSnowflake(1, 1).nextId())
                        .gid(gid)
                        .fullShortUrl(fullShortUrl)
                        .date(currentTime)
                        .country("中国")
                        .province(actualProvince = provinceFlag ? "未知" : province)
                        .city(actualCity = cityFlag ? "未知" : city)
                        .adcode(actualAdcode = adcodeFlag ? "未知" : adcode)
                        .cnt(1)
                        .createTime(currentTime)
                        .updateTime(currentTime)
                        .delFlag(0)
                        .build();
                // 短链接地区统计访问监控插入数据
                linkLocaleStatsMapper.shortLinkLocaleState(linkLocaleStatsDO);
            }


            // 获取浏览器数据
            String browser = LinkUtil.getBrowser(((HttpServletRequest) request));
            // 短链接浏览器统计访问数据准备
            LinkBrowserStatsDO linkBrowserStatsDO = LinkBrowserStatsDO.builder()
                    .id(IdUtil.getSnowflake(1, 1).nextId())
                    .gid(gid)
                    .fullShortUrl(fullShortUrl)
                    .date(currentTime)
                    .browser(browser)
                    .cnt(1)
                    .createTime(currentTime)
                    .updateTime(currentTime)
                    .delFlag(0)
                    .build();
            // 短链接浏览器统计访问监控插入数据
            linkBrowserStatsMapper.shortLinkBrowserState(linkBrowserStatsDO);


            // 获取操作系统数据
            String os = LinkUtil.getOs(((HttpServletRequest) request));
            // 短链接操作系统统计访问数据准备
            LinkOsStatsDO linkOsStatsDO = LinkOsStatsDO.builder()
                    .id(IdUtil.getSnowflake(1, 1).nextId())
                    .gid(gid)
                    .fullShortUrl(fullShortUrl)
                    .date(currentTime)
                    .os(os)
                    .cnt(1)
                    .createTime(currentTime)
                    .updateTime(currentTime)
                    .delFlag(0)
                    .build();
            // 短链接操作系统统计访问监控插入数据
            linkOsStatsMapper.shortLinkOsState(linkOsStatsDO);


            // 获取设备数据
            String device = LinkUtil.getDevice(((HttpServletRequest) request));
            // 短链接设备统计访问数据准备
            LinkDeviceStatsDO linkDeviceStatsDO = LinkDeviceStatsDO.builder()
                    .id(IdUtil.getSnowflake(1, 1).nextId())
                    .gid(gid)
                    .fullShortUrl(fullShortUrl)
                    .date(currentTime)
                    .device(device)
                    .cnt(1)
                    .createTime(currentTime)
                    .updateTime(currentTime)
                    .delFlag(0)
                    .build();
            // 短链接设备统计访问监控插入数据
            linkDeviceStatsMapper.shortLinkDeviceState(linkDeviceStatsDO);


            // 获取网络数据
            String network = LinkUtil.getNetwork(((HttpServletRequest) request));
            // 短链接网络统计访问数据准备
            LinkNetworkStatsDO linkNetworkStatsDO = LinkNetworkStatsDO.builder()
                    .id(IdUtil.getSnowflake(1, 1).nextId())
                    .gid(gid)
                    .fullShortUrl(fullShortUrl)
                    .date(currentTime)
                    .network(network)
                    .cnt(1)
                    .createTime(currentTime)
                    .updateTime(currentTime)
                    .delFlag(0)
                    .build();
            // 短链接网络统计访问监控插入数据
            linkNetworkStatsMapper.shortLinkNetworkState(linkNetworkStatsDO);


            // 短链接访问日志监控数据准备
            LinkAccessLogsDO linkAccessLogsDO = LinkAccessLogsDO.builder()
                    .gid(gid)
                    .user(uvValueAtomic.get())
                    .fullShortUrl(fullShortUrl)
                    .ip(remoteAddr)
                    .locale(StrUtil.join("-", "中国", actualProvince, actualCity))
                    .os(os)
                    .browser(browser)
                    .network(network)
                    .device(device)
                    .build();
            // 短链接访问日志监控插入数据
            linkAccessLogsMapper.insert(linkAccessLogsDO);

        } catch (Exception e) {
            // 监控统计异常
            log.error("短链接监控统计异常", e);
        }
    }

}