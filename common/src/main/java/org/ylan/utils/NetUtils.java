package org.ylan.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.ylan.common.convention.exception.ClientException;

import java.util.Objects;

import static org.ylan.common.constant.NetConstant.*;
import static org.ylan.common.constant.NetConstant.IP_UNKNOWN;
import static org.ylan.common.convention.enums.ShortLinkErrorCodeEnum.URL_REMOVAL_PROTOCOL_ERROR;

/**
 * 网络工具类
 *
 * @author ylan
 */

public class NetUtils {

    /**
     * 去除域名或链接中的协议
     *
     * @return 去除协议后的URL
     */
    public static String removalProtocol(String url){
        if (StringUtils.isBlank(url)){
            throw new ClientException(URL_REMOVAL_PROTOCOL_ERROR);
        }
        if (url.contains(HTTP)){
            return url.substring(7);
        }
        if (url.contains(HTTPS)){
            return url.substring(8);
        }
        return url;
    }

    /**
     * 获取用户访问真实IP
     *
     * @param request HttpServletRequest请求
     * @return 用户访问真实IP
     */
    public static String getActualIp(ServerHttpRequest request) {
        HttpHeaders headers = request.getHeaders();
        String ipAddress = headers.getFirst(X_FORWARDED_FOR);
        if (ipAddress == null || ipAddress.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = headers.getFirst(X_REAL_IP);
        }
        if (ipAddress == null || ipAddress.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = headers.getFirst(PROXY_CLIENT_IP);
        }
        if (ipAddress == null || ipAddress.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = headers.getFirst(WL_PROXY_CLIENT_IP);
        }
        if (ipAddress == null || ipAddress.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = headers.getFirst(HTTP_CLIENT_IP);
        }
        if (ipAddress == null || ipAddress.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = headers.getFirst(HTTP_X_FORWARDED_FOR);
        }
        if (ipAddress == null || ipAddress.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddress().getAddress().getHostAddress();
        }
        // 多个代理的情况，第一个IP为客户端真实IP
        if (!Objects.isNull(ipAddress)){
            ipAddress = ipAddress.split(",")[0].trim();
        }
        return ipAddress;
    }

}