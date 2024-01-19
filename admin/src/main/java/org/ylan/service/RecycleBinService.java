package org.ylan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ylan.common.convention.result.Result;
import org.ylan.remote.dto.req.RecycleBinPageReqDTO;
import org.ylan.remote.dto.resp.RecycleBinPageRespDTO;

/**
 * 回收站接口层
 *
 * @author ylan
 */

public interface RecycleBinService {

    /**
     * 分页查询回收站短链接
     *
     * @param requestParam 回收站短链接分页请求参数
     * @return 回收站短链接分页返回结果 失败抛异常
     */
    Result<Page<RecycleBinPageRespDTO>> pageRecycleBin(RecycleBinPageReqDTO requestParam);
}