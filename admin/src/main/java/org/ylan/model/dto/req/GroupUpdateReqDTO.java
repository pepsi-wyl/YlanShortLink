package org.ylan.model.dto.req;

import lombok.Data;

/**
 * 短链接分组修改参数
 *
 * @author ylan
 */

@Data
public class GroupUpdateReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名
     */
    private String name;
}