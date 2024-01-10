package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.dto.req.ShortLinkGroupStatsReqDTO;
import org.ylan.model.dto.req.ShortLinkStatsReqDTO;
import org.ylan.model.entity.LinkOsStatsDO;

import java.util.HashMap;
import java.util.List;

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

    /**
     * 根据短链接获取指定日期内操作系统监控数据
     *
     * @param requestParam 获取单个短链接监控数据入参
     * @return 获取指定日期内操作系统监控数据
     */
    List<HashMap<String, Object>> listOsStatsByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);

    /**
     * 根据分组获取指定日期内操作系统监控数据
     *
     * @param requestParam 获取分组短链接监控请求参数
     * @return 获取指定日期内操作系统监控数据
     */
    List<HashMap<String, Object>> listOsStatsByGroup(@Param("param") ShortLinkGroupStatsReqDTO requestParam);
}
