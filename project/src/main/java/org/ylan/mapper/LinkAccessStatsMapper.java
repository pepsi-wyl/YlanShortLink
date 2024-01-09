package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.dto.req.ShortLinkStatsReqDTO;
import org.ylan.model.entity.LinkAccessStatsDO;

import java.util.List;

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

    /**
     * 根据短链接获取指定日期内基础监控数据
     *
     * @param requestParam 获取单个短链接监控数据入参
     * @return 获取指定日期内基础监控数据
     */
    List<LinkAccessStatsDO> listStatsByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);

    /**
     * 根据短链接获取指定日期内小时基础监控数据
     *
     * @param requestParam 获取单个短链接监控数据入参
     * @return 获取指定日期内小时基础监控数据
     */
    List<LinkAccessStatsDO> listHourStatsByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);

    /**
     * 根据短链接获取指定日期内星期基础监控数据
     *
     * @param requestParam 获取单个短链接监控数据入参
     * @return 获取指定日期内小时基础监控数据
     */
    List<LinkAccessStatsDO> listWeekdayStatsByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);

}