package org.ylan.model.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接分组创建参数
 *
 * @author ylan
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupSaveReqDTO {

    /**
     * 分组名
     */
    private String name;
}