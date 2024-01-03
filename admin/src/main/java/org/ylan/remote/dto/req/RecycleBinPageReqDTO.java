package org.ylan.remote.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 回收站短链接分页请求参数
 *
 * @author ylan
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class RecycleBinPageReqDTO extends Page {

    /**
     * 分组标识
     */
    private List<String> gidList;
}