package org.ylan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ylan.mapper.LinkNetworkStatsMapper;
import org.ylan.model.entity.LinkNetworkStatsDO;
import org.ylan.service.LinkNetworkStatsService;

/**
 * 短链接网络访问统计访问接口实习层
 *
 * @author ylan
 */

@Service
public class LinkNetworkStatsServiceImpl extends ServiceImpl<LinkNetworkStatsMapper, LinkNetworkStatsDO> implements LinkNetworkStatsService {

}
