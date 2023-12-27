package org.ylan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.ylan.model.dto.req.ShortLinkCreateReqDTO;
import org.ylan.model.dto.req.ShortLinkPageReqDTO;
import org.ylan.model.dto.resp.ShortLinkCreateRespDTO;
import org.ylan.model.dto.resp.ShortLinkGroupCountQueryRespDTO;
import org.ylan.model.dto.resp.ShortLinkPageRespDTO;
import org.ylan.model.entity.ShortLinkDO;

import java.util.List;

/**
 * 短链接接口层
 *
 * @author ylan
 */

public interface ShortLinkService extends IService<ShortLinkDO> {

    /**
     * 创建短链接
     *
     * @param requestParam 创建短链接请求参数
     * @return 短链接创建信息
     */
    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam);

    /**
     * 分页查询短链接
     *
     * @param requestParam 分页查询短链接请求参数
     * @return 短链接分页返回结果
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);

    /**
     * 查询短链接分组内链接数量
     *
     * @param requestParam 查询短链接分组内数量请求参数
     * @return 查询短链接分组内数量响应
     * @return
     */
    List<ShortLinkGroupCountQueryRespDTO> listGroupShortLinkCount(List<String> requestParam);
}