package org.ylan.model.dto.req;

import lombok.Data;

/**
 * 短链接分组创建参数
 *
 * @author ylan
 */

@Data
public class GroupSaveReqDTO {

    /**
     * 分组名
     */
    private String name;
}