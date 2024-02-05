package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.entity.GatewayLogDO;

import java.util.List;

/**
 * 网关日志持久层
 *
 * @author ylan
 */

@Mapper
public interface GatewayLogMapper extends BaseMapper<GatewayLogDO> {

    /**
     * 批量插入网关日志
     */
    int batchSaveGatewayLog(@Param("gatewayLogList") List<GatewayLogDO> gatewayLogList);
}