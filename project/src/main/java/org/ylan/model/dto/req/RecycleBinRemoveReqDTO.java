package org.ylan.model.dto.req;

import lombok.Data;

/**
 * 移除回收站请求实体类
 *
 * @author ylan
 */

@Data
public class RecycleBinRemoveReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 完整短链接
     */
    private String fullShortUrl;
}