package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.entity.GatewayLogHistoryDO;

import java.util.List;

/**
 * 网关历史日志持久层
 *
 * @author ylan
 */

@Mapper
public interface GatewayLogHistoryMapper extends BaseMapper<GatewayLogHistoryDO> {

    /**
     * 批量插入网关日志
     */
    int batchSaveGatewayLog(@Param("gatewayLogHistoryList") List<GatewayLogHistoryDO> gatewayLogHistoryList);

}