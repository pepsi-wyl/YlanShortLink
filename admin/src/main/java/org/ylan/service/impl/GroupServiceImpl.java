package org.ylan.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ylan.common.bit.user.UserContext;
import org.ylan.common.convention.exception.ClientException;
import org.ylan.mapper.GroupMapper;
import org.ylan.model.dto.req.GroupSaveReqDTO;
import org.ylan.model.dto.resp.GroupRespDTO;
import org.ylan.model.entity.GroupDO;
import org.ylan.service.GroupService;
import org.ylan.utils.RandomGeneratorUtils;

import java.util.List;
import java.util.Objects;

import static org.ylan.common.convention.enums.GroupErrorCodeEnum.GROUP_NAME_EXISTS_ERROR;
import static org.ylan.common.convention.enums.GroupErrorCodeEnum.GROUP_SAVE_ERROR;

/**
 * 短链接分组接口实现层
 *
 * @author ylan
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {

    @Override
    public Boolean saveGroup(GroupSaveReqDTO requestParam) {

        // 判断分组名称是否重复
        if (hasName(UserContext.getUsername(),requestParam.getName())){
            throw new ClientException(GROUP_NAME_EXISTS_ERROR);
        }

        // 生成不可重复的gid
        String gid = null;
        do {
            gid = RandomGeneratorUtils.generateRandom();
        }while (hasGid(UserContext.getUsername(), gid));

        GroupDO groupDO = GroupDO.builder()
                .gid(gid)
                .sortOrder(0)
                .username(UserContext.getUsername())
                .name(requestParam.getName())
                .build();

        // 新增短链接分组
        int insert = baseMapper.insert(groupDO);
        if (insert < 0) {
            throw new ClientException(GROUP_SAVE_ERROR);
        }

        return true;
    }

    @Override
    public List<GroupRespDTO> listGroup() {
        // 查询该用户下的所有分组
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .orderByDesc(GroupDO::getSortOrder, GroupDO::getUpdateTime);
        List<GroupDO> groupDOList = baseMapper.selectList(queryWrapper);
        return BeanUtil.copyToList(groupDOList, GroupRespDTO.class);
    }

    /**
     * 判断分组name是否存在
     *
     * @param username
     * @param name
     * @return
     */
    private boolean hasName(String username, String name){
        LambdaQueryWrapper<GroupDO> queryWrapper =
                Wrappers.lambdaQuery(GroupDO.class)
                        .eq(GroupDO::getName, name)
                        .eq(GroupDO::getUsername,username);
        return !Objects.isNull(baseMapper.selectOne(queryWrapper));
    }

    /**
     * 判断分组gid是否存在
     *
     * @param username
     * @param gid
     * @return
     */
    private boolean hasGid(String username, String gid) {
        LambdaQueryWrapper<GroupDO> queryWrapper =
                Wrappers.lambdaQuery(GroupDO.class)
                        .eq(GroupDO::getGid, gid)
                        .eq(GroupDO::getUsername,username);
        return !Objects.isNull(baseMapper.selectOne(queryWrapper));
    }


}