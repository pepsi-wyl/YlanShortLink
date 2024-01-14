package org.ylan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ylan.mapper.LinkDeviceStatsMapper;
import org.ylan.model.entity.LinkDeviceStatsDO;
import org.ylan.service.LinkDeviceStatsService;

/**
 * 短链接设备访问接口实现层
 *
 * @author ylan
 */

@Service
public class LinkDeviceStatsServiceImpl extends ServiceImpl<LinkDeviceStatsMapper, LinkDeviceStatsDO> implements LinkDeviceStatsService {

}