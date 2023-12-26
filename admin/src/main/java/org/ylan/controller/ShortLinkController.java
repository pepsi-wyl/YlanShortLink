package org.ylan.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.ylan.common.convention.result.Result;
import org.ylan.remote.dto.ShortLinkRemoteService;
import org.ylan.remote.dto.req.ShortLinkCreateReqDTO;
import org.ylan.remote.dto.req.ShortLinkPageReqDTO;
import org.ylan.remote.dto.resp.ShortLinkCreateRespDTO;
import org.ylan.remote.dto.resp.ShortLinkPageRespDTO;

/**
 * 短链接管理控制器
 *
 * @author ylan
 */

@RestController
@RequestMapping("/api/short-link/admin/v1")
@RequiredArgsConstructor
public class ShortLinkController {

    /**
     * 短链接服务
     */
    private final ShortLinkRemoteService shortLinkRemoteService;

    /**
     * 创建短链接
     */
    @PostMapping("/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return shortLinkRemoteService.createShortLink(requestParam);
    }

    /**
     * 分页查询短链接
     */
    @GetMapping("/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return shortLinkRemoteService.pageShortLink(requestParam);
    }


}