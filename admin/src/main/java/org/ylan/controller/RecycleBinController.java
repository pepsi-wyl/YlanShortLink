package org.ylan.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ylan.common.convention.result.Result;
import org.ylan.remote.dto.ShortLinkRemoteService;
import org.ylan.remote.dto.req.RecycleBinSaveReqDTO;

/**
 * 回收站管理控控制器
 *
 * @author ylan
 */

@Slf4j
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RecycleBinController {

    /**
     * 短链接中台服务
     */
    private final ShortLinkRemoteService shortLinkRemoteService;

    /**
     * 保存回收站
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/save")
    public Result<Boolean> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam) {
        return shortLinkRemoteService.saveRecycleBin(requestParam);
    }

}