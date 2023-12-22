package org.ylan.service;

import com.baomidou.mybatisplus.extension.service.IService;
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
}