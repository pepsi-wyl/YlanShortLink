package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.dto.req.ShortLinkPageReqDTO;
import org.ylan.model.entity.ShortLinkDO;

/**
 * 短链接持久层
 *
 * @author ylan
 */

@Mapper
public interface ShortLinkMapper extends BaseMapper<ShortLinkDO> {

    /**
     * 短链接访问统计自增
     */
    void incrementStats(
            @Param("gid") String gid,
            @Param("fullShortUrl") String fullShortUrl,
            @Param("clickNum") Integer clickNum,
            @Param("totalPv") Integer totalPv,
            @Param("totalUv") Integer totalUv,
            @Param("totalUip") Integer totalUip
    );

    /**
     * 分页统计短链接 带统计数据
     */
    IPage<ShortLinkDO> pageLink(ShortLinkPageReqDTO requestParam);

    /**
     * 删除短链接并设置del_time
     */
    int delByGidAndFullShortUrl(
            @Param("gid") String gid,
            @Param("fullShortUrl") String fullShortUrl,
            @Param("delTime") Long delTime
    );

}