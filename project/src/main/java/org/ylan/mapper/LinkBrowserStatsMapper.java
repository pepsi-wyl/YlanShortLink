package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.entity.LinkBrowserStatsDO;

/**
 * 短链接浏览器访问监控持久层
 *
 * @author ylan
 */

public interface LinkBrowserStatsMapper extends BaseMapper<LinkBrowserStatsDO> {

    /**
     * 短链接浏览器访问监控
     *
     * @param linkBrowserStats 短链接浏览器访问监控实体
     */
    void shortLinkBrowserState(@Param("linkBrowserStats") LinkBrowserStatsDO linkBrowserStats);
}