package org.ylan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ylan.mapper.GatewayLogHistoryMapper;
import org.ylan.model.entity.GatewayLogHistoryDO;
import org.ylan.service.GatewayLogHistoryService;

/**
 * 网关历史日志接口实现层
 *
 * @author ylan
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class GatewayLogHistoryServiceImpl extends ServiceImpl<GatewayLogHistoryMapper, GatewayLogHistoryDO> implements GatewayLogHistoryService {

}