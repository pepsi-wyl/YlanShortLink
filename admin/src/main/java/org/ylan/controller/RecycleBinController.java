package org.ylan.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.ylan.common.convention.result.Result;
import org.ylan.remote.ShortLinkOpenFeignRemoteService;
import org.ylan.remote.dto.req.RecycleBinPageReqDTO;
import org.ylan.remote.dto.req.RecycleBinRecoverReqDTO;
import org.ylan.remote.dto.req.RecycleBinRemoveReqDTO;
import org.ylan.remote.dto.req.RecycleBinSaveReqDTO;
import org.ylan.remote.dto.resp.RecycleBinPageRespDTO;
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
    private final ShortLinkOpenFeignRemoteService shortLinkOpenFeignRemoteService;

    /**
     * 回收站服务
     */
    private final RecycleBinService recycleBinService;

    /**
     * 保存回收站
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/save")
    public Result<Boolean> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam) {
        return shortLinkOpenFeignRemoteService.saveRecycleBin(requestParam);
    }

    /**
     * 移出回收站
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/recover")
    public Result<Boolean> recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam) {
        return shortLinkOpenFeignRemoteService.recoverRecycleBin(requestParam);
    }

    /**
     * 移除回收站
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/remove")
    public Result<Boolean> removeRecycleBin(@RequestBody RecycleBinRemoveReqDTO requestParam) {
        return shortLinkOpenFeignRemoteService.removeRecycleBin(requestParam);
    }

    /**
     * 分页查询回收站短链接
     */
    @GetMapping("/api/short-link/admin/v1/recycle-bin/page")
    public Result<Page<RecycleBinPageRespDTO>> pageShortLink(RecycleBinPageReqDTO requestParam) {
        return recycleBinService.pageRecycleBin(requestParam);
    }

}