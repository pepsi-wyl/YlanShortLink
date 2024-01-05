package org.ylan.mapper;

import org.apache.ibatis.annotations.Param;
import org.ylan.model.entity.LinkNetworkStatsDO;

/**
 * 短链接网络访问统计访问持久层
 *
 * @author ylan
 */

public interface LinkNetworkStatsMapper {

    /**
     * 短链接网络访问统计访问
     *
     * @param linkNetworkStats 短链接网络访问统计访问实体类
     */
    void shortLinkNetworkState(@Param("linkNetworkStats") LinkNetworkStatsDO linkNetworkStats);
}