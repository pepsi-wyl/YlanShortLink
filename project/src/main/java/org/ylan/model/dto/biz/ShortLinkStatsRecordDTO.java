package org.ylan.model.dto.biz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 短链接统计实体
 *
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class ShortLinkStatsRecordDTO {

    /**
     * gid
     */
    private String gid;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 访问时间
     */
    private Date currentTime;

    /**
     * 访问用户IP
     */
    private String remoteAddr;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 操作设备
     */
    private String device;

    /**
     * 网络
     */
    private String network;

    /**
     * UV值
     */
    private String uvValue;

    /**
     * UV访问标识
     */
    private Boolean uvFlag;

    /**
     * UIP访问标识
     */
    private Boolean uipFlag;
}