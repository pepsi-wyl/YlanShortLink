package org.ylan.model.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接高频访问IP监控响应参数
 *
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class ShortLinkStatsTopIpRespDTO {

    /**
     * IP
     */
    private String ip;

    /**
     * 统计
     */
    private Integer cnt;
}