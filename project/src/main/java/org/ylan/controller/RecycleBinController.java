package org.ylan.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.ylan.common.convention.result.*;
import org.ylan.model.dto.req.*;
import org.ylan.model.dto.resp.*;
import org.ylan.service.RecycleBinService;

/**
 * 回收站控制器
 *
 * @author ylan
 */

@Slf4j
@RestController
@RequestMapping("/api/short-link/v1/recycle-bin")
@RequiredArgsConstructor
public class RecycleBinController {

    /**
     * 回收站服务
     */
    private final RecycleBinService recycleBinService;

    /**
     * 移至回收站
     */
    @PostMapping("/save")
    public Result<Boolean> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam) {
        return Results.success(recycleBinService.saveRecycleBin(requestParam));
    }

    /**
     * 移出回收站
     */
    @PostMapping("/recover")
    public Result<Boolean> recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam) {
        return Results.success(recycleBinService.recoverRecycleBin(requestParam));
    }

    /**
     * 移除回收站
     */
    @PostMapping("/remove")
    public Result<Boolean> removeRecycleBin(@RequestBody RecycleBinRemoveReqDTO requestParam) {
        return Results.success(recycleBinService.removeRecycleBin(requestParam));
    }

    /**
     * 分页查询回收站短链接
     */
    @GetMapping("/page")
    public Result<IPage<RecycleBinPageRespDTO>> pageShortLink(RecycleBinPageReqDTO requestParam) {
        return Results.success(recycleBinService.pageRecycleBin(requestParam));
    }

}