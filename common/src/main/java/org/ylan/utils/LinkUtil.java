package org.ylan.utils;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import jakarta.servlet.http.HttpServletRequest;

import java.net.URI;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import static org.ylan.common.constant.NetConstant.*;
import static org.ylan.common.constant.ShortLinkConstant.DEFAULT_CACHE_VALID_TIME;

/**
 * 短链接工具类
 *
 * @author ylan
 */

public class LinkUtil {

    /**
     * 获取短链接缓存有效期时间
     *
     * @param validDate 有效期时间 永久有效返回一个月有效期
     * @return 有限期时间戳
     */
    public static long getLinkCacheValidTime(Date validDate) {
        return Optional.ofNullable(validDate)
                .map(each -> DateUtil.between(new Date(), each, DateUnit.MS,false))
                .orElse(DEFAULT_CACHE_VALID_TIME);
    }

    /**
     * 获取用户访问真实IP
     *
     * @param request HttpServletRequest请求
     * @return 用户访问真实IP
     */
    public static String getActualIp(HttpServletRequest request) {
        String ipAddress = request.getHeader(X_FORWARDED_FOR);
        if (ipAddress == null || ipAddress.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(X_REAL_IP);
        }
        if (ipAddress == null || ipAddress.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(PROXY_CLIENT_IP);
        }
        if (ipAddress == null || ipAddress.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(WL_PROXY_CLIENT_IP);
        }
        if (ipAddress == null || ipAddress.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(HTTP_CLIENT_IP);
        }
        if (ipAddress == null || ipAddress.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(HTTP_X_FORWARDED_FOR);
        }
        if (ipAddress == null || ipAddress.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        // 多个代理的情况，第一个IP为客户端真实IP
        if (!Objects.isNull(ipAddress)){
            ipAddress = ipAddress.split(",")[0].trim();
        }
        return ipAddress;
    }

    /**
     * 获取用户访问操作系统
     *
     * @param request HttpServletRequest请求
     * @return 用户访问操作系统
     */
    public static String getOs(HttpServletRequest request) {
        String userAgent = request.getHeader(USR_AGENT);
        if (userAgent.toLowerCase().contains(WINDOWS)) {
            return WINDOWS_OS;
        } else if (userAgent.toLowerCase().contains(MAC)) {
            return MAC_OS;
        } else if (userAgent.toLowerCase().contains(LINUX)) {
            return LINUX_OS;
        } else if (userAgent.toLowerCase().contains(ANDROID)) {
            return ANDROID_OS;
        } else if (userAgent.toLowerCase().contains(IPHONE)) {
            return IPHONE_OS;
        } else if (userAgent.toLowerCase().contains(IPAD)) {
            return IPAD_OS;
        } else {
            return UNKNOWN_OS;
        }
    }

    /**
     * 获取用户访问浏览器
     *
     * @param request HttpServletRequest请求
     * @return 用户访问浏览器
     */
    public static String getBrowser(HttpServletRequest request) {
        String userAgent = request.getHeader(USR_AGENT);
        if (userAgent.toLowerCase().contains(EDGE)) {
            return EDGE_BROWSER;
        } else if (userAgent.toLowerCase().contains(CHROME)) {
            return CHROME_BROWSER;
        } else if (userAgent.toLowerCase().contains(SAFARI)) {
            return SAFARI_BROWSER;
        } else if (userAgent.toLowerCase().contains(FIREFOX)) {
            return FIREFOX_BROWSER;
        } else if (userAgent.toLowerCase().contains(OPERA)) {
            return OPERA_BROWSER;
        } else if (userAgent.toLowerCase().contains(IE) || userAgent.toLowerCase().contains(IE11)) {
            return IE_BROWSER;
        } else {
            return UNKNOWN_BROWSER;
        }
    }

    /**
     * 获取用户访问设备
     *
     * @param request HttpServletRequest请求
     * @return 用户访问设备
     */
    public static String getDevice(HttpServletRequest request) {
        String userAgent = request.getHeader(USR_AGENT);
        if (userAgent.toLowerCase().contains(MOBILE)) {
            return MOBILE_DEVICE;
        }
        return PC_DEVICE;
    }

    /**
     * 获取用户访问网络
     *
     * @param request HttpServletRequest请求
     * @return 用户访问网络
     */
    public static String getNetwork(HttpServletRequest request) {
        String actualIp = getActualIp(request);
        return
                actualIp.startsWith(WIFI_IP_1)
                        || actualIp.startsWith(WIFI_IP_2)
                        || actualIp.startsWith(WIFI_IP_3)
                        ? "WIFI" : "Mobile";
    }

    /**
     * 获取原始链接中的域名，如果原始链接包含 www 开头的话需要去掉
     *
     * @param url 创建或者修改短链接的原始链接
     * @return 原始链接中的域名
     */
    public static String extractDomain(String url) {
        String domain = null;
        try {
            URI uri = new URI(url);
            String host = uri.getHost();
            if (StrUtil.isNotBlank(host)) {
                domain = host;
                if (domain.startsWith("www.")) {
                    domain = host.substring(4);
                }
            }
        } catch (Exception ignored) {
        }
        return domain;
    }
}