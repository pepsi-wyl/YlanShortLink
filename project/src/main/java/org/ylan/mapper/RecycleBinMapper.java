package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.ylan.model.entity.ShortLinkDO;

/**
 * 回收站持久层
 *
 * @author ylan
 */

public interface RecycleBinMapper extends BaseMapper<ShortLinkDO> {

    /**
     * 删除回收站中的数据
     */
     int removeRecycleBin(@Param("gid") String gid,
                          @Param("fullShortUrl") String fullShortUrl,
                          @Param("delTime") Long delTime);
}