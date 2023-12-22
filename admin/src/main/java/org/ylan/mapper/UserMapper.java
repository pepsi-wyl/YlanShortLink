package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ylan.model.entity.UserDO;

/**
 * 用户持久层
 *
 * @author ylan
 */

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

}