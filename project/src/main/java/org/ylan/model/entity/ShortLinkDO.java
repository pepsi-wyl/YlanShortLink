package org.ylan.model.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ylan.common.database.BaseDO;

import java.util.Date;

/**
 * 短链接实体
 *
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

@TableName("t_link")
public class ShortLinkDO extends BaseDO {

    @Builder
    public ShortLinkDO(Date createTime, Date updateTime, Integer delFlag, Long id, String gid, String originUrl, String domain, String shortUri, String fullShortUrl, Integer createdType, Integer validDateType, Date validDate, String describe, String favicon, String title, Integer enableStatus, Integer clickNum, Integer totalPv, Integer totalUv, Integer totalUip, Integer todayPv, Integer todayUv, Integer todayUip, Long delTime) {
        super(createTime, updateTime, delFlag);
        this.id = id;
        this.gid = gid;
        this.originUrl = originUrl;
        this.domain = domain;
        this.shortUri = shortUri;
        this.fullShortUrl = fullShortUrl;
        this.createdType = createdType;
        this.validDateType = validDateType;
        this.validDate = validDate;
        this.describe = describe;
        this.favicon = favicon;
        this.title = title;
        this.enableStatus = enableStatus;
        this.clickNum = clickNum;
        this.totalPv = totalPv;
        this.totalUv = totalUv;
        this.totalUip = totalUip;
        this.todayPv = todayPv;
        this.todayUv = todayUv;
        this.todayUip = todayUip;
        this.delTime = delTime;
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
     * 原始链接
     */
    private String originUrl;

    /**
     * 域名
     */
    private String domain;

    /**
     * 短链接
     */
    private String shortUri;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 创建类型 0：接口创建 1：控制台创建
     */
    private Integer createdType;

    /**
     * 有效期类型 0：永久有效 1：自定义
     */
    private Integer validDateType;

    /**
     * 有效期
     */
    @TableField(updateStrategy= FieldStrategy.IGNORED, insertStrategy = FieldStrategy.IGNORED)
    private Date validDate;

    /**
     * 描述 与Mysql关键字冲突故需要使用TableField注解
     */
    @TableField("`describe`")
    private String describe;

    /**
     * 网站标识
     */
    private String favicon;

    /**
     * 网站标题
     */
    private String title;

    /**
     * 启用标识 0：启用 1：未启用
     */
    private Integer enableStatus;

    /**
     * 点击量
     */
    private Integer clickNum;

    /**
     * 历史PV
     */
    private Integer totalPv;

    /**
     * 历史UV
     */
    private Integer totalUv;

    /**
     * 历史UIP
     */
    private Integer totalUip;

    /**
     * 今日PV
     */
    @TableField(exist = false)
    private Integer todayPv;

    /**
     * 今日UV
     */
    @TableField(exist = false)
    private Integer todayUv;

    /**
     * 今日UIP
     */
    @TableField(exist = false)
    private Integer todayUip;

    /**
     * 删除时间
     */
    private Long delTime;
}