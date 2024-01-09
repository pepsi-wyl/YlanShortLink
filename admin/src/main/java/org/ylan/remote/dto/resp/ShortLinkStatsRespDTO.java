package org.ylan.remote.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 获取单个短链接监控数据出参
 *
 * @author ylan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class ShortLinkStatsRespDTO {

    /**
     * 访问量
     */
    private Integer pv;

    /**
     * 独立访客数
     */
    private Integer uv;

    /**
     * 独立IP数
     */
    private Integer uip;

    /**
     * 基础访问详情
     */
    private List<ShortLinkStatsAccessDailyRespDTO> daily;

    /**
     * 地区访问详情（仅国内）
     */
    private List<ShortLinkStatsLocaleCNRespDTO> localeCnStats;

    /**
     * 访问设备类型详情
     */
    private List<ShortLinkStatsDeviceRespDTO> deviceStats;

    /**
     * 浏览器访问详情
     */
    private List<ShortLinkStatsBrowserRespDTO> browserStats;

    /**
     * 操作系统访问详情
     */
    private List<ShortLinkStatsOsRespDTO> osStats;

    /**
     * 访问网络类型详情
     */
    private List<ShortLinkStatsNetworkRespDTO> networkStats;

    /**
     * 小时访问详情
     */
    private List<Integer> hourStats;

    /**
     * 一周访问详情
     */
    private List<Integer> weekdayStats;

    /**
     * 高频访问IP详情
     */
    private List<ShortLinkStatsTopIpRespDTO> topIpStats;

    /**
     * 访客访问类型详情
     */
    private List<ShortLinkStatsUvRespDTO> uvTypeStats;
}