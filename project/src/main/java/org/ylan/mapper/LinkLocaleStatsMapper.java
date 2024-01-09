package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.dto.req.ShortLinkStatsReqDTO;
import org.ylan.model.entity.LinkLocaleStatsDO;

import java.util.List;

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

    /**
     * 根据短链接获取指定日期内地区监控数据
     *
     * @param requestParam 获取单个短链接监控数据入参
     * @return 获取指定日期内地区监控数据
     */
    List<LinkLocaleStatsDO> listLocaleByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);
}