package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ylan.model.entity.GatewayLogDO;

/**
 * 网关日志持久层
 *
 * @author ylan
 */

@Mapper
public interface GatewayLogMapper extends BaseMapper<GatewayLogDO> {

}