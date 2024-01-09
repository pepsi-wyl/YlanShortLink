package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.dto.req.ShortLinkStatsReqDTO;
import org.ylan.model.entity.LinkDeviceStatsDO;

import java.util.List;

/**
 * 短链接设备访问持久层
 *
 * @author ylan
 */

public interface LinkDeviceStatsMapper extends BaseMapper<LinkDeviceStatsDO> {

    /**
     * 短链接设备访问监控
     *
     * @param linkDeviceStats 短链接设备访问实体
     */
    void shortLinkDeviceState(@Param("linkDeviceStats") LinkDeviceStatsDO linkDeviceStats);

    /**
     * 根据短链接获取指定日期内访问设备监控数据
     *
     * @param requestParam 获取单个短链接监控数据入参
     * @return 获取指定日期内访问设备监控数据
     */
    List<LinkDeviceStatsDO> listDeviceStatsByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);
}