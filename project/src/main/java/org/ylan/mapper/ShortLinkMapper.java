package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ylan.model.entity.ShortLinkDO;

/**
 * 短链接持久层
 *
 * @author ylan
 */

@Mapper
public interface ShortLinkMapper extends BaseMapper<ShortLinkDO> {

}