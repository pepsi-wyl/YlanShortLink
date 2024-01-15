package org.ylan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.ylan.model.dto.req.ShortLinkBatchCreateReqDTO;
import org.ylan.model.dto.req.ShortLinkCreateReqDTO;
import org.ylan.model.dto.req.ShortLinkPageReqDTO;
import org.ylan.model.dto.req.ShortLinkUpdateReqDTO;
import org.ylan.model.dto.resp.ShortLinkBatchCreateRespDTO;
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
     * 短链接跳转
     *
     * @param shortUri 短链接后缀
     * @param request  HTTP 请求
     * @param response HTTP 响应
     */
    void restoreUrl(String shortUri, ServletRequest request, ServletResponse response);

    /**
     * 创建短链接
     *
     * @param requestParam 创建短链接请求参数
     * @return 短链接创建信息
     */
    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam);

    /**
     * 批量创建短链接
     *
     * @param requestParam 批量创建短链接请求参数
     * @return 批量创建短链接响应参数
     */
    ShortLinkBatchCreateRespDTO batchCreateShortLink(ShortLinkBatchCreateReqDTO requestParam);

    /**
     * 修改短链接
     *
     * @param requestParam 修改短链接请求参数
     * @return 修改成功返回True 修改失败则抛异常
     */
    Boolean updateShortLink(ShortLinkUpdateReqDTO requestParam);

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

    /**
     * 获取网页的Favicon图标
     *
     * @param url 目标网站地址
     * @return 网站图标链接
     */
    String getFaviconByUrl(String url);

    /**
     * 获取网页的Title标题
     *
     * @param url 目标网站地址
     * @return 网站标题
     */
    String getTitleByUrl(String url);

    /**
     * 查询短链接分组是否可以删除
     *
     * @param gid 分组gid
     * @return 可以删除返回True 不能删除抛异常
     */
    Boolean deleteGroupShortLink(String gid);

}