package org.ylan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Queues;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylan.mapper.GatewayLogMapper;
import org.ylan.model.entity.GatewayLogDO;
import org.ylan.service.GatewayLogService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 网关日志接口实现层
 *
 * @author ylan
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class GatewayLogServiceImpl extends ServiceImpl<GatewayLogMapper, GatewayLogDO> implements GatewayLogService {

    /**
     * 网关日志持久层
     */
    private final GatewayLogMapper gatewayLogMapper;

    /**
     * 是否运行
     */
    volatile boolean isRunning = true;

    /**
     * 最大缓存日志数量 条
     */
    private static final int GatewayLogQueueSize = 1000;

    /**
     * 最大缓存日志时间 秒
     */
    private static final int GatewayLogQueueTime = 60 * 5;

    /**
     * 使用LinkedBlockingQueue缓存数据
     */
    volatile BlockingQueue<GatewayLogDO> gatewayLogQueue = new LinkedBlockingQueue<GatewayLogDO>();

    @PostConstruct
    public void postConstruct() {
        new Thread(() -> {
            while (isRunning) {
                try {
                    List<GatewayLogDO> gatewayLogList = new ArrayList<>(GatewayLogQueueSize + 5);
                    Queues.drain(gatewayLogQueue, gatewayLogList, GatewayLogQueueSize, GatewayLogQueueTime , TimeUnit.SECONDS);
                    batchSaveGatewayLog(gatewayLogList);
                } catch (Throwable e) {
                    log.error("GatewayLog-Queues error", e);
                }
            }
        }).start();
        log.info("GatewayLog-Queues init success");
    }

    @PreDestroy
    public void destroy() {
        isRunning = false;
        List<GatewayLogDO> gatewayLogList = new ArrayList<>(GatewayLogQueueSize + 5);
        gatewayLogQueue.drainTo(gatewayLogList);
        batchSaveGatewayLog(gatewayLogList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchSaveGatewayLog(List<GatewayLogDO> gatewayLogList) {
        if (gatewayLogList.isEmpty()) return false;
        return gatewayLogMapper.batchSaveGatewayLog(gatewayLogList) > 0;
    }

    @Override
    public boolean addGatewayLog(GatewayLogDO gatewayLog) {
        return gatewayLogQueue.add(gatewayLog);
    }

}