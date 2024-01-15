package org.ylan.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.ylan.common.convention.result.Result;
import org.ylan.model.dto.req.ShortLinkCreateReqDTO;
import org.ylan.model.dto.resp.ShortLinkCreateRespDTO;

/**
 * Sentinel流控策略
 *
 * @author ylan
 */

public class CustomBlockHandler {

    /**
     * 创建短链接接口降级处理方法
     */
    public static Result<ShortLinkCreateRespDTO> createShortLinkBlockHandlerMethod(ShortLinkCreateReqDTO requestParam, BlockException exception) {
        return new Result<ShortLinkCreateRespDTO>().setCode("B100000").setMessage("当前访问网站人数过多，请稍后再试...");
    }

}