package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.entity.LinkOsStatsDO;

/**
 * 操作系统统计访问监控持久层
 *
 * @author ylan
 */

public interface LinkOsStatsMapper extends BaseMapper<LinkOsStatsDO> {

    /**
     * 操作系统统计访问监控
     *
     * @param linkOsStats 操作系统统计访问实体类
     */
    void shortLinkOsState(@Param("linkOsStats") LinkOsStatsDO linkOsStats);
}
