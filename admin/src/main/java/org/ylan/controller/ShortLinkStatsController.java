package org.ylan.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ylan.common.convention.result.Result;
import org.ylan.remote.dto.ShortLinkRemoteService;
import org.ylan.remote.dto.req.ShortLinkStatsAccessRecordReqDTO;
import org.ylan.remote.dto.req.ShortLinkStatsReqDTO;
import org.ylan.remote.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import org.ylan.remote.dto.resp.ShortLinkStatsRespDTO;

/**
 * 短链接监控控制器
 *
 * @author ylan
 */

@Slf4j
@RestController
@RequiredArgsConstructor
public class ShortLinkStatsController {

    /**
     * 短链接中台服务
     */
    private final ShortLinkRemoteService shortLinkRemoteService;

    /**
     * 访问单个短链接指定时间内监控数据
     */
    @GetMapping("/api/short-link/admin/v1/stats")
    public Result<ShortLinkStatsRespDTO> shortLinkStats(ShortLinkStatsReqDTO requestParam) {
        return shortLinkRemoteService.oneShortLinkStats(requestParam);
    }

    /**
     * 访问单个短链接指定时间内访问记录监控数据
     */
    @GetMapping("/api/short-link/admin/v1/stats/access-record")
    public Result<IPage<ShortLinkStatsAccessRecordRespDTO>> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam) {
        return shortLinkRemoteService.shortLinkStatsAccessRecord(requestParam);
    }

}