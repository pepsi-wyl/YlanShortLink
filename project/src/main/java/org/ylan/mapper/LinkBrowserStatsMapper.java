package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.dto.req.ShortLinkGroupStatsReqDTO;
import org.ylan.model.dto.req.ShortLinkStatsReqDTO;
import org.ylan.model.entity.LinkBrowserStatsDO;

import java.util.HashMap;
import java.util.List;

/**
 * 短链接浏览器访问监控持久层
 *
 * @author ylan
 */

public interface LinkBrowserStatsMapper extends BaseMapper<LinkBrowserStatsDO> {

    /**
     * 短链接浏览器访问监控
     *
     * @param linkBrowserStats 短链接浏览器访问监控实体
     */
    void shortLinkBrowserState(@Param("linkBrowserStats") LinkBrowserStatsDO linkBrowserStats);

    /**
     * 根据短链接获取指定日期内浏览器监控数据
     *
     * @param requestParam 获取单个短链接监控数据入参
     * @return 获取指定日期内浏览器监控数据
     */
    List<HashMap<String, Object>> listBrowserStatsByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);

    /**
     * 根据分组获取指定日期内浏览器监控数据
     *
     * @param requestParam 获取分组短链接监控请求参数
     * @return 获取指定日期内浏览器监控数据
     */
    List<HashMap<String, Object>> listBrowserStatsByGroup(@Param("param") ShortLinkGroupStatsReqDTO requestParam);

    /**
     * 删除短链接浏览器访问
     *
     * @param gid           分组ID
     * @param fullShortUrl  完整短链接
     */
    int deleteByGidAndFullShortUrl(@Param("gid") String gid, @Param("fullShortUrl") String fullShortUrl);

}