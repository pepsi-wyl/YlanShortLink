package org.ylan.remote.dto;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ylan.common.convention.result.Result;
import org.ylan.remote.dto.req.*;
import org.ylan.remote.dto.resp.GroupCountQueryRespDTO;
import org.ylan.remote.dto.resp.RecycleBinPageRespDTO;
import org.ylan.remote.dto.resp.ShortLinkCreateRespDTO;
import org.ylan.remote.dto.resp.ShortLinkPageRespDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 短链接中台服务
 *
 * @author luan
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ShortLinkRemoteServiceImpl implements ShortLinkRemoteService{

    // todo 后续重构为 SpringCloud Feign 调用
    private static final String HOST = "http://127.0.0.1:8001";

    @Override
    public Result<ShortLinkCreateRespDTO> createShortLink(ShortLinkCreateReqDTO requestParam) {
        // 封装请求参数
        String jsonString = JSON.toJSONString(requestParam);
        log.info("【 创建短链接-POST-请求参数 】【 {} 】", jsonString);
        // 发送请求
        String resultBodyStr = HttpUtil.post(HOST + "/api/short-link/v1/create", jsonString);
        log.info("【 创建短链接响应结果 】 【 {} 】", resultBodyStr);
        // 转化响应
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {});
    }

    @Override
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        // 封装请求参数
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("gid", requestParam.getGid());
        requestMap.put("current", requestParam.getCurrent());
        requestMap.put("size", requestParam.getSize());
        log.info("【 分页查询短链接-POST-请求参数 】【 {} 】", requestMap);
        // 发送请求
        String resultBodyStr = HttpUtil.get(HOST + "/api/short-link/v1/page", requestMap);
        log.info("【 分页查询短链接 】 【 {} 】", resultBodyStr);
        // 转化响应
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {});
    }

    @Override
    public Result<List<GroupCountQueryRespDTO>> listGroupShortLinkCount(List<String> requestParam) {
        // 封装请求参数
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("requestParam", requestParam);
        log.info("【 查询短链接分组内链接数量-GET-请求参数 】【 {} 】", requestMap);
        // 发送请求
        String resultBodyStr = HttpUtil.get(HOST + "/api/short-link/v1/group/count", requestMap);
        log.info("【 查询短链接分组内链接数量 】 【 {} 】", resultBodyStr);
        // 转化响应
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {});
    }

    @Override
    public Result<String> getFaviconByUrl(String url) {
        // 封装请求参数
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("url", url);
        log.info("【 获取网页的Favicon图标-GET-请求参数 】【 {} 】", requestMap);
        String resultBodyStr = HttpUtil.get(HOST + "/api/short-link/v1/favicon", requestMap);
        log.info("【 获取网页的Favicon图标 】 【 {} 】", resultBodyStr);
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {});
    }

    @Override
    public Result<String> getTitleByUrl(String url) {
        // 封装请求参数
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("url", url);
        log.info("【 获取网页的Title标题-GET-请求参数 】【 {} 】", requestMap);
        String resultBodyStr = HttpUtil.get(HOST + "/api/short-link/v1/title" , requestMap);
        log.info("【 获取网页的Title标题 】 【 {} 】", resultBodyStr);
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {});
    }

    @Override
    public Result<Boolean> saveRecycleBin(RecycleBinSaveReqDTO requestParam) {
        // 封装请求参数
        String jsonString = JSON.toJSONString(requestParam);
        log.info("【 移至回收站-POST-请求参数 】【 {} 】", jsonString);
        // 发送请求
        String resultBodyStr = HttpUtil.post(HOST + "/api/short-link/v1/recycle-bin/save", jsonString);
        log.info("【 移至回收站响应结果 】 【 {} 】", resultBodyStr);
        // 转化响应
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {});
    }

    @Override
    public Result<Boolean> recoverRecycleBin(RecycleBinRecoverReqDTO requestParam) {
        // 封装请求参数
        String jsonString = JSON.toJSONString(requestParam);
        log.info("【 移出回收站-POST-请求参数 】【 {} 】", jsonString);
        // 发送请求
        String resultBodyStr = HttpUtil.post(HOST + "/api/short-link/v1/recycle-bin/recover", jsonString);
        log.info("【 移出回收站响应结果 】 【 {} 】", resultBodyStr);
        // 转化响应
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {});
    }

    @Override
    public Result<Boolean> removeRecycleBin(RecycleBinRemoveReqDTO requestParam) {
        // 封装请求参数
        String jsonString = JSON.toJSONString(requestParam);
        log.info("【 移除回收站-POST-请求参数 】【 {} 】", jsonString);
        // 发送请求
        String resultBodyStr = HttpUtil.post(HOST + "/api/short-link/v1/recycle-bin/remove", jsonString);
        log.info("【 移除回收站响应结果 】 【 {} 】", resultBodyStr);
        // 转化响应
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {});
    }

    @Override
    public Result<IPage<RecycleBinPageRespDTO>> pageRecycleBin(RecycleBinPageReqDTO requestParam) {
        // 封装请求参数
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("gidList", requestParam.getGidList());
        requestMap.put("current", requestParam.getCurrent());
        requestMap.put("size", requestParam.getSize());
        log.info("【 分页查询回收站短链接-GET-请求参数 】【 {} 】", requestMap);
        String resultBodyStr = HttpUtil.get(HOST + "/api/short-link/v1/recycle-bin/page" , requestMap);
        log.info("【 分页查询回收站短链接 】 【 {} 】", resultBodyStr);
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {});
    }

}