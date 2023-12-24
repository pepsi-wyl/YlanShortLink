package org.ylan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ylan.model.entity.GroupDO;

/**
 * 短链接分组持久层
 *
 * @author ylan
 */

@Mapper
public interface GroupMapper extends BaseMapper<GroupDO> {

}