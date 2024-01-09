package org.ylan.model.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接访问设备监控响应参数
 *
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class ShortLinkStatsDeviceRespDTO {

    /**
     * 设备类型
     */
    private String device;

    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 占比
     */
    private Double ratio;
}