package org.ylan.remote.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.ylan.common.convention.result.Result;
import org.ylan.remote.dto.req.ShortLinkCreateReqDTO;
import org.ylan.remote.dto.req.ShortLinkPageReqDTO;
import org.ylan.remote.dto.resp.ShortLinkCreateRespDTO;
import org.ylan.remote.dto.resp.ShortLinkPageRespDTO;

/**
 * 短链接中台服务
 *
 * @author ylan
 */


public interface ShortLinkRemoteService {

    /**
     * 创建短链接
     *
     * @param requestParam 创建短链接请求参数
     * @return 短链接创建响应
     */
    public Result<ShortLinkCreateRespDTO> createShortLink(ShortLinkCreateReqDTO requestParam);

    /**
     * 分页查询短链接
     *
     * @param requestParam 分页短链接请求参数
     * @return 查询短链接响应
     */
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam);

}