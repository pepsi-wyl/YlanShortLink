package org.ylan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ylan.common.convention.result.Result;
import org.ylan.common.convention.result.Results;
import org.ylan.model.dto.resp.UserRespDTO;
import org.ylan.service.UserService;

/**
 * 用户管理控制器
 *
 * @author ylan
 */

@RestController
@RequestMapping("/api/short-link/admin/v1/")
@RequiredArgsConstructor
public class UserController {

    /**
     *  用户服务
     */
    private final UserService userService;

    /**
     * 根据用户名获取用户信息
     */
    @GetMapping("/user/{username}")
    public Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUsername(username));
    }

}