package org.ylan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ylan.mapper.LinkStatsTodayMapper;
import org.ylan.model.entity.LinkStatsTodayDO;
import org.ylan.service.LinkStatsTodayService;

/**
 * 短链接今日统计接口实现层
 *
 * @author ylan
 */

@Service
public class LinkStatsTodayServiceImpl extends ServiceImpl<LinkStatsTodayMapper, LinkStatsTodayDO> implements LinkStatsTodayService {

}