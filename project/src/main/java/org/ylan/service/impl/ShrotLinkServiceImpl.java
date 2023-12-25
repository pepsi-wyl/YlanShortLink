package org.ylan.service.impl;

import cn.hutool.core.text.StrBuilder;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBloomFilter;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.ylan.common.convention.exception.ServiceException;
import org.ylan.mapper.ShortLinkMapper;
import org.ylan.model.dto.req.ShortLinkCreateReqDTO;
import org.ylan.model.dto.resp.ShortLinkCreateRespDTO;
import org.ylan.model.entity.ShortLinkDO;
import org.ylan.service.ShortLinkService;
import org.ylan.utils.HashUtils;

import java.util.Objects;

import static org.ylan.common.convention.enums.ShortLinkErrorCodeEnum.*;

/**
 * 短链接接口实现层
 *
 * @author ylan
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ShrotLinkServiceImpl extends ServiceImpl<ShortLinkMapper, ShortLinkDO> implements ShortLinkService {

    /**
     *  防止短链接创建查询数据库的布隆过滤器
     */
    private final RBloomFilter<String> shortUriCreateCachePenetrationBloomFilter;

    @Override
    public ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam) {

        // 生成的短链接url后缀
        String shortUri = generateSuffix(requestParam);
        // 生成的短链接url
        String fullShortUrl = StrBuilder.create(requestParam.getDomain()).append("/").append(shortUri).toString();

        // 短链接实体数据
        ShortLinkDO shortLinkDO = ShortLinkDO.builder()
                .gid(requestParam.getGid())
                .originUrl(requestParam.getOriginUrl())
                .domain(requestParam.getDomain())
                .shortUri(shortUri)
                .fullShortUrl(fullShortUrl)
                .createdType(requestParam.getCreatedType())
                .validDateType(requestParam.getValidDateType())
                .validDate(requestParam.getValidDate())
                .describe(requestParam.getDescribe())
                .enableStatus(0)
                .build();

        try {
            // 插入短链接实体数据
            int insert = baseMapper.insert(shortLinkDO);
            if (insert < 1){
                throw new ServiceException(SHORT_LINK_SAVE_ERROR);
            }
        } catch (DuplicateKeyException ex) {
            // 完整短链接重复错误
            if (!Objects.isNull(baseMapper.selectOne(Wrappers.lambdaQuery(ShortLinkDO.class).eq(ShortLinkDO::getFullShortUrl, fullShortUrl)))) {
                log.error("短链接：{} 重复入库", fullShortUrl);
                throw new ServiceException(SHORT_LINK_GENERATE_REPEAT_ERROR);
            }
        }

        // 完整短链接 加入布隆过滤器中
        shortUriCreateCachePenetrationBloomFilter.add(fullShortUrl);

        // 返回 ShortLinkCreateRespDTO 对象
        return ShortLinkCreateRespDTO.builder()
                .gid(requestParam.getGid())
                .originUrl(requestParam.getOriginUrl())
                .fullShortUrl(fullShortUrl)
                .build();
    }

    /**
     * 生成短链接后缀
     */
    private String generateSuffix(ShortLinkCreateReqDTO requestParam) {
        String shortUri;
        int customGenerateCount = 0;
        while (true) {
            // 调用生成的次数 每次加1 最多生成10次
            customGenerateCount ++;
            if (customGenerateCount >= 10) {
                throw new ServiceException(SHORT_LINK_GENERATE_ERROR);
            }

            // 生成短链接后缀 原始链接 加入 时间戳(随机盐) 之后去调用 短链接生产算法 防止重复
            shortUri = HashUtils.hashToBase62(StrBuilder.create(requestParam.getOriginUrl()).append(System.currentTimeMillis()).toString());

            // 完整短链接
            String fullShortUrl = StrBuilder.create(requestParam.getDomain())
                    .append("/")
                    .append(shortUri)
                    .toString();

            // 完整短链接 布隆过滤器中没有则直接返回
            if (!shortUriCreateCachePenetrationBloomFilter.contains(fullShortUrl)) {
                return shortUri;
            }
        }
    }

}