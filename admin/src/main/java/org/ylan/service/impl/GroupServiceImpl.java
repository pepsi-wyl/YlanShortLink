package org.ylan.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ylan.common.bit.user.UserContext;
import org.ylan.common.convention.exception.ClientException;
import org.ylan.common.convention.exception.ServiceException;
import org.ylan.common.convention.result.Result;
import org.ylan.mapper.GroupMapper;
import org.ylan.model.dto.req.GroupSaveReqDTO;
import org.ylan.model.dto.req.GroupSortReqDTO;
import org.ylan.model.dto.req.GroupUpdateReqDTO;
import org.ylan.model.dto.resp.GroupRespDTO;
import org.ylan.model.entity.GroupDO;
import org.ylan.remote.dto.ShortLinkRemoteService;
import org.ylan.remote.dto.resp.GroupCountQueryRespDTO;
import org.ylan.service.GroupService;
import org.ylan.utils.RandomGeneratorUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.ylan.common.convention.enums.GroupErrorCodeEnum.*;

/**
 * 短链接分组接口实现层
 *
 * @author ylan
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {

    /**
     * 短链接中台服务
     */
    private final ShortLinkRemoteService shortLinkRemoteService;

    @Override
    public Boolean saveGroup(GroupSaveReqDTO requestParam) {
         return saveGroup(UserContext.getUsername(),requestParam);
    }

    @Override
    public Boolean saveGroup(String username, GroupSaveReqDTO requestParam) {
        // 判断分组名称是否重复
        if (hasName(username, requestParam.getName())){
            throw new ClientException(GROUP_NAME_EXISTS_ERROR);
        }

        // 生成不可重复的gid
        String gid = null;
        do {
            gid = RandomGeneratorUtils.generateRandom();
        }while (hasGid(username, gid));

        GroupDO groupDO = GroupDO.builder()
                .gid(gid)
                .sortOrder(0)
                .username(username)
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
        // 查询每个分组下的短链数量
        Result<List<GroupCountQueryRespDTO>> listResult = shortLinkRemoteService.listGroupShortLinkCount(groupDOList.stream().map(GroupDO::getGid).toList());
        // 进行链接数量设置
        List<GroupRespDTO> groupRespDTOList = BeanUtil.copyToList(groupDOList, GroupRespDTO.class);
        groupRespDTOList.forEach(groupRespDTO -> {
            Optional<GroupCountQueryRespDTO> first = listResult.getData().stream()
                    .filter(groupCountQueryRespDTO -> Objects.equals(groupCountQueryRespDTO.getGid(), groupRespDTO.getGid()))
                    .findFirst();
            first.ifPresent(item -> groupRespDTO.setShortLinkCount(first.get().getShortLinkCount()));
        });
        return groupRespDTOList;
    }

    @Override
    public Boolean updateGroup(GroupUpdateReqDTO requestParam) {

        // 判断分组名称是否重复
        if (hasName(UserContext.getUsername(),requestParam.getName())){
            throw new ClientException(GROUP_NAME_EXISTS_ERROR);
        }

        // 更新条件 username gid
        LambdaUpdateWrapper<GroupDO> updateWrapper = Wrappers.lambdaUpdate(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getGid, requestParam.getGid());
        // 更新的分组名称
        GroupDO groupDO = GroupDO.builder()
                .name(requestParam.getName())
                .build();

        baseMapper.update(groupDO, updateWrapper);
        return true;
    }

    @Override
    public Boolean deleteGroup(String gid) {

        // 删除分组 如果下面有链接 则不能删除
        Result<Boolean> result = shortLinkRemoteService.deleteGroupShortLink(gid);
        if (!Objects.isNull(result) && !Result.SUCCESS_CODE.equals(result.getCode())){
            throw new ServiceException(result.getMessage());
        }

        // 删除条件 username gid
        LambdaUpdateWrapper<GroupDO> updateWrapper = Wrappers.lambdaUpdate(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getGid, gid);
        int delete = baseMapper.delete(updateWrapper);
        if (delete< 1){
            throw new ServiceException(GROUP_DELETE_ERROR);
        }

        return true;
    }

    @Override
    public Boolean sortGroup(List<GroupSortReqDTO> requestParam) {
        requestParam.forEach(groupSortReqDTO -> {
            // 更新之后的sort值
            GroupDO groupDO = GroupDO.builder()
                    .sortOrder(groupSortReqDTO.getSortOrder())
                    .build();
            // 更新条件 username gid
            LambdaUpdateWrapper<GroupDO> updateWrapper = Wrappers.lambdaUpdate(GroupDO.class)
                    .eq(GroupDO::getUsername, UserContext.getUsername())
                    .eq(GroupDO::getGid, groupSortReqDTO.getGid());
            baseMapper.update(groupDO, updateWrapper);
        });
        return true;
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