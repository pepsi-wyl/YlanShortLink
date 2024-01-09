package org.ylan.remote.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接访问网络监控响应参数
 *
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class ShortLinkStatsNetworkRespDTO {

    /**
     * 访问网络
     */
    private String network;

    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 占比
     */
    private Double ratio;
}