package org.ylan.service;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.ylan.model.dto.req.ShortLinkStatsReqDTO;
import org.ylan.model.dto.resp.ShortLinkStatsRespDTO;

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

    /**
     * 获取单个短链接监控数据
     *
     * @param requestParam 获取单个短链接监控数据入参
     * @return 获取单个短链接监控数据出参
     */
    ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam);
}