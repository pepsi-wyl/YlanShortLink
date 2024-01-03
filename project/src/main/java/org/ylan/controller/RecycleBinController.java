package org.ylan.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ylan.common.convention.result.Result;
import org.ylan.common.convention.result.Results;
import org.ylan.model.dto.req.RecycleBinRecoverReqDTO;
import org.ylan.model.dto.req.RecycleBinSaveReqDTO;
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

}