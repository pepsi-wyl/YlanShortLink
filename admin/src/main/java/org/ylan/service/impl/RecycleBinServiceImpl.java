package org.ylan.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ylan.common.bit.user.UserContext;
import org.ylan.common.convention.exception.ServiceException;
import org.ylan.common.convention.result.Result;
import org.ylan.mapper.GroupMapper;
import org.ylan.model.entity.GroupDO;
import org.ylan.remote.dto.ShortLinkRemoteService;
import org.ylan.remote.dto.req.RecycleBinPageReqDTO;
import org.ylan.remote.dto.resp.RecycleBinPageRespDTO;
import org.ylan.service.RecycleBinService;

import java.util.List;

import static org.ylan.common.convention.enums.GroupErrorCodeEnum.GROUP_LIST_NOT_FOUND_ERROR;

/**
 * 回收站接口实现层
 *
 * @author ylan
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class RecycleBinServiceImpl implements RecycleBinService {

    /**
     * 短链接中台服务
     */
    private final ShortLinkRemoteService shortLinkRemoteService;

    /**
     * 分组Mapper
     */
    private final GroupMapper groupMapper;

    @Override
    public Result<IPage<RecycleBinPageRespDTO>> pageRecycleBin(RecycleBinPageReqDTO requestParam) {
        // 准备gid列表
        LambdaQueryWrapper<GroupDO> queryWrapper =
                Wrappers.lambdaQuery(GroupDO.class).eq(GroupDO::getUsername, UserContext.getUsername());
        List<GroupDO> groupDOList = groupMapper.selectList(queryWrapper);
        if (CollUtil.isEmpty(groupDOList)) {
            throw new ServiceException(GROUP_LIST_NOT_FOUND_ERROR);
        }
        requestParam.setGidList(groupDOList.stream().map(GroupDO::getGid).toList());

        return shortLinkRemoteService.pageRecycleBin(requestParam);
    }

}