package org.ylan.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.apache.ibatis.type.Alias;
import org.ylan.common.database.BaseDO;

import java.util.Date;

/**
 * 短链接网络访问统计访问实体类
 *
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Alias("LinkNetworkStatsDO")
@TableName("t_link_network_stats")
public class LinkNetworkStatsDO extends BaseDO {

    @Builder
    public LinkNetworkStatsDO(Long id, String gid, String fullShortUrl, Date date, String network, Integer cnt, Date createTime, Date updateTime, Integer delFlag) {
        super(createTime, updateTime, delFlag);
        this.id = id;
        this.gid = gid;
        this.fullShortUrl = fullShortUrl;
        this.date = date;
        this.network = network;
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
     * 访问网络
     */
    private String network;

    /**
     * 访问量
     */
    private Integer cnt;

}