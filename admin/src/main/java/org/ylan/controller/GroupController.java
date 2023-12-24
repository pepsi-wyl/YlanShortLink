package org.ylan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ylan.common.convention.result.Result;
import org.ylan.common.convention.result.Results;
import org.ylan.model.dto.req.GroupSaveReqDTO;
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

    /**
     * 新增短链接分组
     */
    @PostMapping("/group")
    public Result<Boolean> saveGroup(@RequestBody GroupSaveReqDTO requestParam){
        return Results.success(groupService.saveGroup(requestParam));
    }

}