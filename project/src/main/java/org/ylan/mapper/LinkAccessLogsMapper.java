package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.dto.req.ShortLinkStatsReqDTO;
import org.ylan.model.entity.LinkAccessLogsDO;
import org.ylan.model.entity.LinkAccessStatsDO;

import java.util.HashMap;
import java.util.List;

/**
 * 短链接访问日志监控持久层
 *
 * @author ylan
 */


public interface LinkAccessLogsMapper extends BaseMapper<LinkAccessLogsDO> {

    /**
     * 根据短链接获取指定日期内PV、UV、UIP数据
     *
     * @param requestParam 获取单个短链接监控数据入参
     * @return 获取指定日期内PV、UV、UIP数据
     */
    LinkAccessStatsDO findPvUvUidStatsByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);

    /**
     * 根据分组获取指定日期内高频访问IP数据
     *
     * @param requestParam 获取单个短链接监控数据入参
     * @return 获取指定日期内高频访问IP数据
     */
    List<HashMap<String, Object>> listTopIpByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);

    /**
     * 根据短链接获取指定日期内新旧访客数据
     *
     * @param requestParam 获取单个短链接监控数据入参
     * @return 获取指定日期内新旧访客数据
     */
    HashMap<String, Object> findUvTypeCntByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);
}