package org.ylan.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ylan.service.ShortLinkService;

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

}