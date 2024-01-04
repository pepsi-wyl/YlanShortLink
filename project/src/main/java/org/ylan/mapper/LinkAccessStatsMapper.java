package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.entity.LinkAccessStatsDO;

/**
 * 短链接基础访问监控持久层
 *
 * @author ylan
 */

public interface LinkAccessStatsMapper extends BaseMapper<LinkAccessStatsDO> {

    /**
     * 短链接基础访问监控
     *
     * @param linkAccessStats 短链接基础访问监控实体类
     */
    void shortLinkStats(@Param("linkAccessStats") LinkAccessStatsDO linkAccessStats);
}