package org.ylan.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * 网关历史日志实体
 *
 * @author ylan
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("GatewayLogHistoryDO")
@TableName("t_link_gateway_log_history")
public class GatewayLogHistoryDO implements Serializable {

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 1983879536575766072L;

    /**
     * 链路追踪ID
     */
    private String traceId;

    /**
     * ip
     */
    private String ip;

    /**
     * 协议
     */
    @TableField("`schema`")
    private String schema;

    /**
     * 请求方法
     */
    private String requestMethod;

    /**
     * 请求路径
     */
    private String requestPath;

    /**
     * 请求数据类型
     */
    private String requestContentType;

    /**
     * 请求体
     */
    private String requestBody;

    /**
     * 返回数据类型
     */
    private String responseContentType;

    /**
     * 响应体
     */
    private String responseData;

    /**
     * 请求时间
     */
    private Date requestTime;

    /**
     * 响应时间
     */
    private Date responseTime;

    /**
     * 执行时间
     */
    private long executeTime;

    /**
     * 访问实例
     */
    private String targetServer;

    /**
     * 路由配置
     */
    private String routeConfig;

}