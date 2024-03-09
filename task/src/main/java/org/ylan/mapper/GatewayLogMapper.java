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
     * 获取超过10天的1000条日志数据
     */
    List<GatewayLogDO> getBatchGatewayLog();

    /**
     * 根据traceIds删除日志数据
     */
    void deleteBatchGatewayLogByTraceIds(@Param("traceIds") List<String> traceIds);

}