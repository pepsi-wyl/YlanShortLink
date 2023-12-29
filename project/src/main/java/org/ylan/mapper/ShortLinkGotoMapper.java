package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ylan.model.entity.ShortLinkGotoDO;

/**
 * 短链接跳转持久层
 *
 * @author ylan
 */

@Mapper
public interface ShortLinkGotoMapper extends BaseMapper<ShortLinkGotoDO> {

}