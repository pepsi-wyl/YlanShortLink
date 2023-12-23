package org.ylan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.ylan.model.dto.req.UserRegisterReqDTO;
import org.ylan.model.dto.req.UserUpdateReqDTO;
import org.ylan.model.dto.resp.UserRespDTO;
import org.ylan.model.entity.UserDO;

/**
 * 用户接口层
 *
 * @author ylan
 */

public interface UserService extends IService<UserDO> {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户返回实体
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * 根据用户名查询用户是否存在
     *
     * @param username 用户名
     * @return 用户名存在返回 True，不存在返回 False
     */
    Boolean hasUserByUsername(String username);

    /**
     * 注册用户
     *
     * @param requestParam 注册用户请求参数
     */
    void register(UserRegisterReqDTO requestParam);

    /**
     * 根据用户名修改用户
     *
     * @param requestParam
     */
    void update(UserUpdateReqDTO requestParam);
}