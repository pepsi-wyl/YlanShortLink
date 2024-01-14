package org.ylan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ylan.mapper.LinkAccessLogsMapper;
import org.ylan.model.entity.LinkAccessLogsDO;
import org.ylan.service.LinkAccessLogsService;

/**
 * 短链接访问日志监控接口实现层
 *
 * @author ylan
 */

@Service
public class LinkAccessLogsServiceImpl extends ServiceImpl<LinkAccessLogsMapper, LinkAccessLogsDO> implements LinkAccessLogsService {

}