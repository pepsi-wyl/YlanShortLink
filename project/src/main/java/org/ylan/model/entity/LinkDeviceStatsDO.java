package org.ylan.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.apache.ibatis.type.Alias;
import org.ylan.common.database.BaseDO;

import java.util.Date;

/**
 * 短链接设备访问实体
 *
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Alias("LinkDeviceStatsDO")
@TableName("t_link_device_stats")
public class LinkDeviceStatsDO extends BaseDO {

    @Builder
    public LinkDeviceStatsDO(Long id, String gid, String fullShortUrl, Date date, String device, Integer cnt, Date createTime, Date updateTime, Integer delFlag) {
        super(createTime, updateTime, delFlag);
        this.id = id;
        this.gid = gid;
        this.fullShortUrl = fullShortUrl;
        this.date = date;
        this.device = device;
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
     * 访问设备
     */
    private String device;

    /**
     * 访问量
     */
    private Integer cnt;

}