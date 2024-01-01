package org.ylan.remote.dto.req;

import lombok.Data;

/**
 * 移至回收站请求实体类
 *
 * @author ylan
 */

@Data
public class RecycleBinSaveReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 完整短链接
     */
    private String fullShortUrl;
}