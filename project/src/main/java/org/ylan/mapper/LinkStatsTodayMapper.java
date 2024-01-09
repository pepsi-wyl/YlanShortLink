package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.entity.LinkStatsTodayDO;

/**
 * 短链接今日统计持久层
 *
 * @author ylan
 */

public interface LinkStatsTodayMapper extends BaseMapper<LinkStatsTodayDO> {

    /**
     * 短链接今日统计监控
     *
     * @param linkTodayStats 短链接今日统计实体
     */
    void shortLinkTodayState(@Param("linkTodayStats") LinkStatsTodayDO linkTodayStats);
}