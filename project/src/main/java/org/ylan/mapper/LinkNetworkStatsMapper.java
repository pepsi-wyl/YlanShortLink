package org.ylan.mapper;

import org.apache.ibatis.annotations.Param;
import org.ylan.model.dto.req.ShortLinkStatsReqDTO;
import org.ylan.model.entity.LinkNetworkStatsDO;

import java.util.List;

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

    /**
     * 根据短链接获取指定日期内访问网络监控数据
     *
     * @param requestParam 获取单个短链接监控数据入参
     * @return 获取指定日期内访问网络监控数据
     */
    List<LinkNetworkStatsDO> listNetworkStatsByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);
}