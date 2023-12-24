package org.ylan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ylan.service.GroupService;

/**
 * 短链接分组控制器
 *
 * @author ylan
 */

@RestController
@RequestMapping("/api/short-link/admin/v1/")
@RequiredArgsConstructor
public class GroupController {

    /**
     * 短链接分组服务
     */
    private final GroupService groupService;

}