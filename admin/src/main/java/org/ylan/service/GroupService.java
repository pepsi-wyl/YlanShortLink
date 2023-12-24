package org.ylan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.ylan.model.dto.req.GroupSaveReqDTO;
import org.ylan.model.entity.GroupDO;

/**
 * 短链接分组接口层
 *
 * @author ylan
 */

public interface GroupService extends IService<GroupDO> {

    /**
     * 新增短链接分组
     *
     * @param requestParam
     * @return
     */
    Boolean saveGroup(GroupSaveReqDTO requestParam);
}