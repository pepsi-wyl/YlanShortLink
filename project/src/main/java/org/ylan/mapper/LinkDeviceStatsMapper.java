package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.entity.LinkDeviceStatsDO;

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
}