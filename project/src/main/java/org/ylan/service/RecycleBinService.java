package org.ylan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.ylan.model.dto.req.*;
import org.ylan.model.dto.resp.*;
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

    /**
     * 分页查询回收站短链接
     *
     * @param requestParam 回收站短链接分页请求参数
     * @return 回收站短链接分页返回结果 失败抛异常
     */
    IPage<RecycleBinPageRespDTO> pageRecycleBin(RecycleBinPageReqDTO requestParam);

}