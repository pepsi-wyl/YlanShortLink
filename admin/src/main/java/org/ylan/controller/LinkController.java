package org.ylan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ylan.common.convention.result.Result;
import org.ylan.remote.dto.ShortLinkRemoteService;

/**
 * 链接控制器
 *
 * @author ylan
 */

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class LinkController {

    /**
     * 短链接中台服务
     */
    private final ShortLinkRemoteService shortLinkRemoteService;

    /**
     * 获取网页的Favicon图标
     */
    @GetMapping("/api/short-link/v1/admin/favicon")
    public Result<String> getFaviconByUrl(@RequestParam("url") String url) {
        return shortLinkRemoteService.getFaviconByUrl(url);
    }

    /**
     * 获取网页的Title标题
     */
    @GetMapping("/api/short-link/v1/admin/title")
    public Result<String> getTitleByUrl(@RequestParam("url") String url) {
        return shortLinkRemoteService.getTitleByUrl(url);
    }

}