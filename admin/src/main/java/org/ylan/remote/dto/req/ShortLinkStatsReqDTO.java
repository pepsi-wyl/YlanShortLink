package org.ylan.remote.dto.req;

import lombok.Data;

/**
 * 获取单个短链接监控数据入参
 *
 * @author ylan
 */

@Data
public class ShortLinkStatsReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;
}