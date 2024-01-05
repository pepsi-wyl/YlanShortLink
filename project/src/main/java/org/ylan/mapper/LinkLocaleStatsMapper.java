package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.entity.LinkLocaleStatsDO;

/**
 * 短链接地区统计访问持久层
 *
 * @author ylan
 */

public interface LinkLocaleStatsMapper extends BaseMapper<LinkLocaleStatsDO> {

    /**
     * 短链接地区统计访问监控
     *
     * @param linkLocaleStats 短链接地区统计访问实体类
     */
    void shortLinkLocaleState(@Param("linkLocaleStats") LinkLocaleStatsDO linkLocaleStats);
}