package org.ylan.remote.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.ylan.common.convention.result.Result;
import org.ylan.remote.dto.req.RecycleBinSaveReqDTO;
import org.ylan.remote.dto.req.ShortLinkCreateReqDTO;
import org.ylan.remote.dto.req.ShortLinkPageReqDTO;
import org.ylan.remote.dto.resp.GroupCountQueryRespDTO;
import org.ylan.remote.dto.resp.ShortLinkCreateRespDTO;
import org.ylan.remote.dto.resp.ShortLinkPageRespDTO;

import java.util.List;

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
    Result<ShortLinkCreateRespDTO> createShortLink(ShortLinkCreateReqDTO requestParam);

    /**
     * 分页查询短链接
     *
     * @param requestParam 分页短链接请求参数
     * @return 查询短链接响应
     */
    Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam);

    /**
     * 查询短链接分组内链接数量
     *
     * @param requestParam 查询短链接分组内数量请求参数
     * @return 查询短链接分组内数量响应
     * @return
     */
    Result<List<GroupCountQueryRespDTO>> listGroupShortLinkCount(List<String> requestParam);

    /**
     * 获取网页的Favicon图标
     *
     * @param url 目标网站地址
     * @return 网站图标链接
     */
    Result<String> getFaviconByUrl(String url);

    /**
     * 获取网页的Title标题
     *
     * @param url 目标网站地址
     * @return 网站标题
     */
    Result<String> getTitleByUrl(String url);


    /**
     * 移至回收站
     *
     * @param requestParam 移至回收站请求参数
     * @return 成功返回True 失败抛异常
     */
    Result<Boolean> saveRecycleBin(RecycleBinSaveReqDTO requestParam);
}