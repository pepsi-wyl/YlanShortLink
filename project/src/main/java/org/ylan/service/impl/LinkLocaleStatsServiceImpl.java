package org.ylan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ylan.mapper.LinkLocaleStatsMapper;
import org.ylan.model.entity.LinkLocaleStatsDO;
import org.ylan.service.LinkLocaleStatsService;

/**
 * 短链接地区统计访问接口实现层
 *
 * @author ylan
 */

@Service
public class LinkLocaleStatsServiceImpl extends ServiceImpl<LinkLocaleStatsMapper, LinkLocaleStatsDO> implements LinkLocaleStatsService {

}