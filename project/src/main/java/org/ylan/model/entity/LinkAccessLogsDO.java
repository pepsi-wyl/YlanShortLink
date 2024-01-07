package org.ylan.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.apache.ibatis.type.Alias;
import org.ylan.common.database.BaseDO;

import java.util.Date;

/**
 * 短链接访问日志监控实体
 *
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Alias("LinkAccessLogsDO")
@TableName("t_link_access_logs")
public class LinkAccessLogsDO extends BaseDO {

    @Builder
    public LinkAccessLogsDO(Long id, String gid, String user, String fullShortUrl, String ip, String locale, String os, String browser, String network, String device, Date createTime, Date updateTime, Integer delFlag) {
        super(createTime, updateTime, delFlag);
        this.id = id;
        this.gid = gid;
        this.user = user;
        this.fullShortUrl = fullShortUrl;
        this.ip = ip;
        this.locale = locale;
        this.os = os;
        this.browser = browser;
        this.network = network;
        this.device = device;
    }

    /**
     * id
     */
    private Long id;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 用户信息
     */
    private String user;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 访问IP
     */
    private String ip;

    /**
     * 访问地区
     */
    private String locale;

    /**
     * 访问操作系统
     */
    private String os;

    /**
     * 访问浏览器
     */
    private String browser;

    /**
     * 访问网络
     */
    private String network;

    /**
     * 访问设备
     */
    private String device;

}