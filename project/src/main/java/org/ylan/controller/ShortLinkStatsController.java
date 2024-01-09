package org.ylan.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ylan.common.convention.result.Result;
import org.ylan.common.convention.result.Results;
import org.ylan.model.dto.req.ShortLinkStatsReqDTO;
import org.ylan.model.dto.resp.ShortLinkStatsRespDTO;
import org.ylan.service.ShortLinkStatsService;

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
     * 短链接监控服务接口层
     */
    private  final ShortLinkStatsService shortLinkStatsService;

    /**
     * 访问单个短链接指定时间内监控数据
     */
    @GetMapping("/api/short-link/v1/stats")
    public Result<ShortLinkStatsRespDTO> shortLinkStats(ShortLinkStatsReqDTO requestParam) {
        return Results.success(shortLinkStatsService.oneShortLinkStats(requestParam));
    }

}