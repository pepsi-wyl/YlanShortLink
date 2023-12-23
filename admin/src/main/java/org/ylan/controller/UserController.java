package org.ylan.controller;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.ylan.common.convention.result.Result;
import org.ylan.common.convention.result.Results;
import org.ylan.model.dto.req.UserLoginReqDTO;
import org.ylan.model.dto.req.UserRegisterReqDTO;
import org.ylan.model.dto.req.UserUpdateReqDTO;
import org.ylan.model.dto.resp.UserActualRespDTO;
import org.ylan.model.dto.resp.UserLoginRespDTO;
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

    /**
     * 根据用户名获取无脱敏用户信息
     */
    @GetMapping("/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUsername(@PathVariable("username") String username) {
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualRespDTO.class));
    }

    /**
     * 根据用户名查询用户是否存在
     *
     * @Deprecated
     */
    @Deprecated
    @GetMapping("/user/has-username")
    public Result<Boolean> hasUsername(@RequestParam("username") String username) {
        return Results.success(userService.hasUserByUsername(username));
    }

    /**
     * 根据用户名查询用户是否存在
     */
    @GetMapping("/user/hasUserByUsername")
    public Result<Boolean> hasUserByUsername(@RequestParam("username") String username) {
        return Results.success(userService.hasUserByUsername(username));
    }

    /**
     * 注册用户
     */
    @PostMapping("/user")
    public Result<Void> register(@RequestBody UserRegisterReqDTO requestParam) {
        userService.register(requestParam);
        return Results.success();
    }

    /**
     * 根据用户名修改用户
     */
    @PutMapping("/user")
    public Result<Void> update(@RequestBody UserUpdateReqDTO requestParam) {
        userService.update(requestParam);
        return Results.success();
    }

    /**
     * 用户登录
     */
    @PostMapping("/user/login")
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO requestParam) {
        return Results.success(userService.login(requestParam));
    }

    /**
     * 检查用户是否登录
     */
    @GetMapping("/user/check-login")
    public Result<Boolean> checkLogin(@RequestParam("username") String username, @RequestParam("token") String token) {
        return Results.success(userService.checkLogin(username, token));
    }

    /**
     * 用户退出登录
     */
    @DeleteMapping("/user/logout")
    public Result<Boolean> logout(@RequestParam("username") String username, @RequestParam("token") String token) {
        return Results.success(userService.logout(username, token));
    }

}