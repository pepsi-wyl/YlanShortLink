package org.ylan.model.dto.req;

import lombok.Data;

/**
 * 短链接分组排序参数
 *
 * @author ylan
 */

@Data
public class GroupSortReqDTO {

    /**
     * 分组ID
     */
    private String gid;

    /**
     * 排序值
     */
    private Integer sortOrder;
}