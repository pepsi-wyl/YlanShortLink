package org.ylan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ylan.mapper.GatewayLogMapper;
import org.ylan.model.entity.GatewayLogDO;
import org.ylan.service.GatewayLogService;

/**
 * 网关日志接口实现层
 *
 * @author ylan
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class GatewayLogServiceImpl extends ServiceImpl<GatewayLogMapper, GatewayLogDO> implements GatewayLogService {

}