package org.ylan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.ylan.model.dto.req.GroupSaveReqDTO;
import org.ylan.model.dto.req.GroupUpdateReqDTO;
import org.ylan.model.dto.resp.GroupRespDTO;
import org.ylan.model.entity.GroupDO;

import java.util.List;

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

    /**
     * 查询用户短链接分组集合
     *
     * @return 用户短链接分组集合
     */
    List<GroupRespDTO> listGroup();

    /**
     * 修改短链接分组
     *
     * @param requestParam 修改链接分组参数
     * @return 成功返回True 失败抛异常
     */
    Boolean updateGroup(GroupUpdateReqDTO requestParam);

    /**
     * 删除短链接分组
     *
     * @param gid 短链接分组标识
     */
    Boolean deleteGroup(String gid);
}