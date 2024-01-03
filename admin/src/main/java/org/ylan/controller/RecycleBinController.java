package org.ylan.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.ylan.common.convention.result.Result;
import org.ylan.remote.dto.ShortLinkRemoteService;
import org.ylan.remote.dto.req.*;
import org.ylan.remote.dto.resp.*;
import org.ylan.service.RecycleBinService;

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
     * 回收站服务
     */
    private final RecycleBinService recycleBinService;

    /**
     * 保存回收站
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/save")
    public Result<Boolean> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam) {
        return shortLinkRemoteService.saveRecycleBin(requestParam);
    }

    /**
     * 移出回收站
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/recover")
    public Result<Boolean> recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam) {
        return shortLinkRemoteService.recoverRecycleBin(requestParam);
    }

    /**
     * 移除回收站
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/remove")
    public Result<Boolean> removeRecycleBin(@RequestBody RecycleBinRemoveReqDTO requestParam) {
        return shortLinkRemoteService.removeRecycleBin(requestParam);
    }

    /**
     * 分页查询回收站短链接
     */
    @GetMapping("/api/short-link/admin/v1/recycle-bin/page")
    public Result<IPage<RecycleBinPageRespDTO>> pageShortLink(RecycleBinPageReqDTO requestParam) {
        return recycleBinService.pageRecycleBin(requestParam);
    }

}