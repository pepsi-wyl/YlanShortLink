package org.ylan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.ylan.model.dto.req.ShortLinkGroupStatsAccessRecordReqDTO;
import org.ylan.model.dto.req.ShortLinkGroupStatsReqDTO;
import org.ylan.model.dto.req.ShortLinkStatsAccessRecordReqDTO;
import org.ylan.model.dto.req.ShortLinkStatsReqDTO;
import org.ylan.model.dto.resp.ShortLinkStatsAccessRecordRespDTO;
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

    /**
     * 获取分组短链接监控数据
     *
     * @param requestParam 获取分组短链接监控数据入参
     * @return 获取分组短链接监控数据出参
     */
    ShortLinkStatsRespDTO groupShortLinkStats(ShortLinkGroupStatsReqDTO requestParam);

    /**
     * 访问单个短链接指定时间内访问记录监控数据
     *
     * @param requestParam 获取短链接监控访问记录数据入参
     * @return 访问记录监控数据
     */
    IPage<ShortLinkStatsAccessRecordRespDTO> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam);

    /**
     * 访问分组短链接指定时间内访问记录监控数据
     *
     * @param requestParam 获取分组短链接监控访问记录数据入参
     * @return 分组访问记录监控数据
     */
    IPage<ShortLinkStatsAccessRecordRespDTO> groupShortLinkStatsAccessRecord(ShortLinkGroupStatsAccessRecordReqDTO requestParam);
}