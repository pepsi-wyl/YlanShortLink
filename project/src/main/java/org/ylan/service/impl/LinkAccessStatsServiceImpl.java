package org.ylan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ylan.mapper.LinkAccessStatsMapper;
import org.ylan.model.entity.LinkAccessStatsDO;
import org.ylan.service.LinkAccessStatsService;

/**
 * 短链接基础访问监控接口实现层
 *
 * @author ylan
 */

@Service
public class LinkAccessStatsServiceImpl extends ServiceImpl<LinkAccessStatsMapper, LinkAccessStatsDO> implements LinkAccessStatsService {

}