package org.ylan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ylan.mapper.LinkBrowserStatsMapper;
import org.ylan.model.entity.LinkBrowserStatsDO;
import org.ylan.service.LinkBrowserStatsService;

/**
 * 短链接浏览器访问监控实现层
 *
 * @author ylan
 */

@Service
public class LinkBrowserStatsServiceImpl extends ServiceImpl<LinkBrowserStatsMapper, LinkBrowserStatsDO> implements LinkBrowserStatsService {

}