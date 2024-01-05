package org.ylan.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.apache.ibatis.type.Alias;
import org.ylan.common.database.BaseDO;

import java.util.Date;

/**
 * 短链接浏览器访问监控实体
 *
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder

@Alias("LinkBrowserStatsDO")
@TableName("t_link_browser_stats")
public class LinkBrowserStatsDO extends BaseDO {

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
     * 浏览器
     */
    private String browser;

    /**
     * 访问量
     */
    private Integer cnt;

}