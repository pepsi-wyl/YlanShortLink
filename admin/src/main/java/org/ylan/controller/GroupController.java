package org.ylan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.ylan.common.convention.result.Result;
import org.ylan.common.convention.result.Results;
import org.ylan.model.dto.req.GroupSaveReqDTO;
import org.ylan.model.dto.req.GroupSortReqDTO;
import org.ylan.model.dto.req.GroupUpdateReqDTO;
import org.ylan.model.dto.resp.GroupRespDTO;
import org.ylan.service.GroupService;

import java.util.List;

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

    /**
     * 查询用户短链接分组集合
     */
    @GetMapping("/group")
    public Result<List<GroupRespDTO>> listGroup(){
        return Results.success(groupService.listGroup());
    }

    /**
     * 修改短链接分组
     */
    @PutMapping("/group")
    public Result<Boolean> updateGroup(@RequestBody GroupUpdateReqDTO requestParam){
        return Results.success(groupService.updateGroup(requestParam));
    }

    /**
     * 删除短链接分组
     */
    @DeleteMapping("/group")
    public Result<Boolean> updateGroup(@RequestParam String gid) {
        return Results.success(groupService.deleteGroup(gid));
    }

    /**
     * 短链接分组排序
     */
    @PostMapping("/group/sort")
    public Result<Boolean> sortGroup(@RequestBody List<GroupSortReqDTO> requestParam) {
        return Results.success(groupService.sortGroup(requestParam));
    }
}