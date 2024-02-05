package org.ylan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.ylan.model.entity.GatewayLogDO;

import java.util.List;

/**
 * 网关日志接口层
 *
 * @author ylan
 */

public interface GatewayLogService extends IService<GatewayLogDO> {

    /**
     * 批量保存网关日志
     */
    boolean batchSaveGatewayLog(List<GatewayLogDO> gatewayLogList);

    /**
     * 添加网关日志，到达一定量后批量插入
     */
    boolean addGatewayLog(GatewayLogDO gatewayLog);

}