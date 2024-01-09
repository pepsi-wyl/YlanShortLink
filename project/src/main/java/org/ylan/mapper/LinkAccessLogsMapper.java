package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.dto.req.ShortLinkStatsReqDTO;
import org.ylan.model.entity.LinkAccessLogsDO;
import org.ylan.model.entity.LinkAccessStatsDO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 获取用户信息是否新老访客
     *
     * @param gid           分组Gid
     * @param fullShortUrl  完整短链接
     * @param startDate     开始时间
     * @param endDate       结束时间
     * @param userAccessLogsList 用户访问日志列表
     * @return 访客信息
     */
    List<Map<String, Object>> selectUvTypeByUsers(
            @Param("gid") String gid,
            @Param("fullShortUrl") String fullShortUrl,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("userAccessLogsList") List<String> userAccessLogsList
    );
}