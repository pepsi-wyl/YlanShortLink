package org.ylan.model.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接地区监控响应参数
 *
 * @author ylan
 */

@Data

@NoArgsConstructor
@AllArgsConstructor

@Builder
public class ShortLinkStatsLocaleCNRespDTO {

    /**
     * 地区
     */
    private String locale;

    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 占比
     */
    private Double ratio;
}