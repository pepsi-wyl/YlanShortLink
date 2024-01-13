package org.ylan.remote.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接基础信息响应参数
 *
 * @author ylan
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class ShortLinkBaseInfoRespDTO {

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 描述信息
     */
    private String describe;

    /**
     * 短链接
     */
    private String fullShortUrl;
}