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

    /**
     * 删除短链接今日统计监控
     *
     * @param gid           分组ID
     * @param fullShortUrl  完整短链接
     */
    int deleteByGidAndFullShortUrl(@Param("gid") String gid, @Param("fullShortUrl") String fullShortUrl);
}