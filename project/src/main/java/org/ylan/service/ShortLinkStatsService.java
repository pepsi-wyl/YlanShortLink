package org.ylan.service;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * 短链接监控服务接口层
 *
 * @author ylan
 */

public interface ShortLinkStatsService {

    /**
     * 短链接统计方法
     *
     * @param gid           分组ID
     * @param fullShortUrl  完整短链接
     * @param request       请求
     * @param response      响应
     */
    void shortLinkStats(String gid, String fullShortUrl, ServletRequest request, ServletResponse response);
}