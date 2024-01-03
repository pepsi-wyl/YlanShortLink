package org.ylan.model.dto.req;

import lombok.Data;

/**
 * 移出回收站请求实体类
 *
 * @author ylan
 */

@Data
public class RecycleBinRecoverReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 全部短链接
     */
    private String fullShortUrl;
}