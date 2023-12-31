package org.ylan.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.apache.ibatis.type.Alias;
import org.ylan.common.database.BaseDO;

import java.util.Date;

/**
 * 短链接基础访问监控实体类
 *
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Alias("LinkAccessStatsDO")
@TableName("t_link_access_stats")
public class LinkAccessStatsDO extends BaseDO {

    @Builder
    public LinkAccessStatsDO(Long id, String gid, String fullShortUrl, Date date, Integer hour, Integer weekday, Integer pv, Integer uv, Integer uip, Date createTime, Date updateTime, Integer delFlag) {
        super(createTime, updateTime, delFlag);
        this.id = id;
        this.gid = gid;
        this.fullShortUrl = fullShortUrl;
        this.date = date;
        this.hour = hour;
        this.weekday = weekday;
        this.pv = pv;
        this.uv = uv;
        this.uip = uip;
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
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 日期
     */
    private Date date;

    /**
     * 小时
     */
    private Integer hour;

    /**
     * 星期
     */
    private Integer weekday;

    /**
     * 访问量
     */
    private Integer pv;

    /**
     * 独立访客数
     */
    private Integer uv;

    /**
     * 独立ip数
     */
    private Integer uip;

}