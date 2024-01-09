package org.ylan.model.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接操作系统监控响应参数
 *
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class ShortLinkStatsOsRespDTO {

    /**
     * 操作系统
     */
    private String os;

    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 占比
     */
    private Double ratio;
}