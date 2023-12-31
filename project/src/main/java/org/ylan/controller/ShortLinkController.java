package org.ylan.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.ylan.common.convention.result.Result;
import org.ylan.common.convention.result.Results;
import org.ylan.model.dto.req.ShortLinkCreateReqDTO;
import org.ylan.model.dto.req.ShortLinkPageReqDTO;
import org.ylan.model.dto.resp.ShortLinkCreateRespDTO;
import org.ylan.model.dto.resp.ShortLinkGroupCountQueryRespDTO;
import org.ylan.model.dto.resp.ShortLinkPageRespDTO;
import org.ylan.service.ShortLinkService;

import java.util.List;

/**
 * 短链接控制器
 *
 * @author ylan
 */

@Slf4j
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ShortLinkController {

    /**
     * 短链接服务
     */
    private final ShortLinkService shortLinkService;

    /**
     * 短链接跳转原始链接
     */
    @GetMapping("/{short-uri}")
    public void restoreUrl(@PathVariable("short-uri") String shortUri, ServletRequest request, ServletResponse response) {
        shortLinkService.restoreUrl(shortUri, request, response);
    }

    /**
     * 创建短链接
     */
    @PostMapping("/api/short-link/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam){
       return Results.success(shortLinkService.createShortLink(requestParam));
    }

    /**
     * 分页查询短链接
     */
    @GetMapping("/api/short-link/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return Results.success(shortLinkService.pageShortLink(requestParam));
    }

    /**
     * 查询短链接分组内链接数量
     */
    @GetMapping("/api/short-link/v1/group/count")
    public Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(@RequestParam("requestParam") List<String> requestParam){
        return Results.success(shortLinkService.listGroupShortLinkCount(requestParam));
    }

    /**
     * 查询短链接分组是否可以删除
     */
    @GetMapping("/api/short-link/v1/group/delete")
    public Result<Boolean> deleteGroupShortLink(@RequestParam("gid") String gid){
       return Results.success(shortLinkService.deleteGroupShortLink(gid));
    }

}