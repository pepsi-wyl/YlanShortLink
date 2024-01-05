package org.ylan.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.apache.ibatis.type.Alias;
import org.ylan.common.database.BaseDO;

import java.util.Date;

/**
 * 短链接地区统计访问实体类
 *
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Alias("LinkLocaleStatsDO")
@TableName("t_link_locale_stats")
public class LinkLocaleStatsDO extends BaseDO {

    @Builder
    public LinkLocaleStatsDO(Long id, String gid, String fullShortUrl, Date date, String country, String province, String city, String adcode, Integer cnt, Date createTime, Date updateTime, Integer delFlag) {
        super(createTime, updateTime, delFlag);
        this.id = id;
        this.gid = gid;
        this.fullShortUrl = fullShortUrl;
        this.date = date;
        this.country = country;
        this.province = province;
        this.city = city;
        this.adcode = adcode;
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
     * 国家名称
     */
    private String country;

    /**
     * 省份名称
     */
    private String province;

    /**
     * 市区名称
     */
    private String city;

    /**
     * 城市编码
     */
    private String adcode;

    /**
     * 访问量
     */
    private Integer cnt;

}