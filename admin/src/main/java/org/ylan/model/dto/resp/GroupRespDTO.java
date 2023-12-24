package org.ylan.model.dto.resp;

import lombok.Data;

/**
 * 短链接分组返回实体对象
 *
 * @author ylan
 */

@Data
public class GroupRespDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 创建分组用户名
     */
    private String username;

    /**
     * 分组排序
     */
    private Integer sortOrder;
}