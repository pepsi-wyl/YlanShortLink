package org.ylan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.ylan.model.dto.req.RecycleBinRecoverReqDTO;
import org.ylan.model.dto.req.RecycleBinRemoveReqDTO;
import org.ylan.model.dto.req.RecycleBinSaveReqDTO;
import org.ylan.model.entity.ShortLinkDO;

/**
 * 回收站接口层
 *
 * @author ylan
 */

public interface RecycleBinService extends IService<ShortLinkDO> {

    /**
     * 移至回收站
     *
     * @param requestParam 移至回收站请求参数
     * @return 成功返回True 失败抛异常
     */
    Boolean saveRecycleBin(RecycleBinSaveReqDTO requestParam);

    /**
     * 移出回收站
     *
     * @param requestParam 移出回收站请求参数
     * @return 成功返回True 失败抛异常
     */
    Boolean recoverRecycleBin(RecycleBinRecoverReqDTO requestParam);

    /**
     * 移除回收站
     *
     * @param requestParam 移除回收站请求参数
     * @return 成功返回True 失败抛异常
     */
    Boolean removeRecycleBin(RecycleBinRemoveReqDTO requestParam);
}