package org.ylan.config;

import lombok.Data;

import java.util.List;

/**
 * SpringCloud Gateway Token拦截器 配置类
 *
 * @author ylan
 */

@Data
public class Config {

    /**
     * 白名单前置路径
     */
    private List<String> whitePathList;
}