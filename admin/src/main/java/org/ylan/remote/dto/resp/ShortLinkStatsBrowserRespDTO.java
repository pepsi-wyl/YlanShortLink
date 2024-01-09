package org.ylan.remote.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接浏览器监控响应参数
 *
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class ShortLinkStatsBrowserRespDTO {

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 占比
     */
    private Double ratio;
}