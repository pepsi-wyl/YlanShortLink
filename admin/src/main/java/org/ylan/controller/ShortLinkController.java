package org.ylan.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.ylan.common.convention.exception.ServiceException;
import org.ylan.common.convention.result.Result;
import org.ylan.common.convention.result.Results;
import org.ylan.model.dto.req.ShortLinkUpdateReqDTO;
import org.ylan.remote.dto.ShortLinkRemoteService;
import org.ylan.remote.dto.req.ShortLinkBatchCreateReqDTO;
import org.ylan.remote.dto.req.ShortLinkCreateReqDTO;
import org.ylan.remote.dto.req.ShortLinkPageReqDTO;
import org.ylan.remote.dto.resp.ShortLinkBaseInfoRespDTO;
import org.ylan.remote.dto.resp.ShortLinkBatchCreateRespDTO;
import org.ylan.remote.dto.resp.ShortLinkCreateRespDTO;
import org.ylan.remote.dto.resp.ShortLinkPageRespDTO;
import org.ylan.utils.EasyExcelWebUtil;

import java.util.List;

import static org.ylan.common.convention.enums.ShortLinkErrorCodeEnum.SHORT_LINK_TO_EXCEL_ERROR;

/**
 * 短链接管理控制器
 *
 * @author ylan
 */

@Slf4j
@RestController
@RequestMapping("/api/short-link/admin/v1")
@RequiredArgsConstructor
public class ShortLinkController {

    /**
     * 短链接服务
     */
    private final ShortLinkRemoteService shortLinkRemoteService;

    /**
     * 创建短链接
     */
    @PostMapping("/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return shortLinkRemoteService.createShortLink(requestParam);
    }

    /**
     * 批量创建短链接
     */
    @SuppressWarnings("all")
    @PostMapping("/create/batch")
    public void batchCreateShortLink(@RequestBody ShortLinkBatchCreateReqDTO requestParam, HttpServletResponse response) {
        Result<ShortLinkBatchCreateRespDTO> shortLinkBatchCreateRespDTOResult = shortLinkRemoteService.batchCreateShortLink(requestParam);
        try {
            if (shortLinkBatchCreateRespDTOResult.isSuccess()) {
                List<ShortLinkBaseInfoRespDTO> baseLinkInfos = shortLinkBatchCreateRespDTOResult.getData().getBaseLinkInfos();
                EasyExcelWebUtil.write(response, "批量创建短链接-SaaS短链接系统", ShortLinkBaseInfoRespDTO.class, baseLinkInfos);
            }else {
                log.error("批量创建短链接失败{}", shortLinkBatchCreateRespDTOResult.getCode() + ":" + shortLinkBatchCreateRespDTOResult.getMessage());
                throw new ServiceException(shortLinkBatchCreateRespDTOResult.getMessage());
            }
        }catch (RuntimeException e){
            log.error("批量创建短链接失败",e);
            throw new ServiceException(SHORT_LINK_TO_EXCEL_ERROR);
        }
    }

    /**
     * 修改短链接
     */
    @PostMapping("/update")
    public Result<Boolean> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        return shortLinkRemoteService.updateShortLink(requestParam);
    }

    /**
     * 分页查询短链接
     */
    @GetMapping("/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return shortLinkRemoteService.pageShortLink(requestParam);
    }


}