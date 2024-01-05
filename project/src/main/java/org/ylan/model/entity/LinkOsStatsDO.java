package org.ylan.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.apache.ibatis.type.Alias;
import org.ylan.common.database.BaseDO;

import java.util.Date;

/**
 * 操作系统统计访问监控实体类
 *
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Alias("LinkOsStatsDO")
@TableName("t_link_os_stats")
public class LinkOsStatsDO extends BaseDO {

    @Builder
    public LinkOsStatsDO(Long id, String gid, String fullShortUrl, Date date, String os, Integer cnt, Date createTime, Date updateTime, Integer delFlag) {
        super(createTime, updateTime, delFlag);
        this.id = id;
        this.gid = gid;
        this.fullShortUrl = fullShortUrl;
        this.date = date;
        this.os = os;
        this.cnt = cnt;
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
     * 操作系统
     */
    private String os;

    /**
     * 访问量
     */
    private Integer cnt;

}