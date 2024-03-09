package org.ylan.task.job;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.ylan.mapper.GatewayLogHistoryMapper;
import org.ylan.mapper.GatewayLogMapper;
import org.ylan.model.entity.GatewayLogDO;
import org.ylan.model.entity.GatewayLogHistoryDO;

import java.util.List;

/**
 * 网关日志数据备份迁移任务
 *
 * @author ylan
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class GateWayLogRestoreJob extends QuartzJobBean {

    /**
     * GatewayLogMapper
     */
    private final GatewayLogMapper gatewayLogMapper;

    /**
     * GatewayLogHistoryMapper
     */
    private final GatewayLogHistoryMapper gatewayLogHistoryMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("开始迁移的网关日志数据");
        // 批量查日志
        List<GatewayLogDO> batchGatewayLog = gatewayLogMapper.getBatchGatewayLog();
        if (!batchGatewayLog.isEmpty()){
            // 批量插入日志
            gatewayLogHistoryMapper.batchSaveGatewayLog(BeanUtil.copyToList(batchGatewayLog, GatewayLogHistoryDO.class));
            // 批量删除日志
            gatewayLogMapper.deleteBatchGatewayLogByTraceIds(batchGatewayLog.stream().map(GatewayLogDO::getTraceId).toList());
        }else {
            log.info("没有需要迁移的网关日志数据");
        }
    }

}