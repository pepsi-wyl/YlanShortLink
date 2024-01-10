package org.ylan.model.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import org.ylan.model.entity.ShortLinkDO;

/**
 * 短链接分页请求参数
 *
 * @author ylan
 */

@Data
public class ShortLinkPageReqDTO extends Page<ShortLinkDO> {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 排序标识
     */
    private String orderTag;
}