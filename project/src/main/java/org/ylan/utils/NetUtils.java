package org.ylan.utils;

import org.apache.commons.lang3.StringUtils;
import org.ylan.common.convention.exception.ClientException;

import static org.ylan.common.constant.NetConstant.HTTP;
import static org.ylan.common.constant.NetConstant.HTTPS;
import static org.ylan.common.convention.enums.ShortLinkErrorCodeEnum.URL_REMOVAL_PROTOCOL_ERROR;

/**
 * 网络工具类
 *
 * @author ylan
 */

public class NetUtils {

    /**
     * 去除域名或链接中的协议
     *
     * @return 去除协议后的URL
     */
    public static String removalProtocol(String url){
        if (StringUtils.isBlank(url)){
            throw new ClientException(URL_REMOVAL_PROTOCOL_ERROR);
        }
        if (url.contains(HTTP)){
            return url.substring(7);
        }
        if (url.contains(HTTPS)){
            return url.substring(8);
        }
        return url;
    }
}