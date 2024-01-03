package org.ylan.common.convention.enums;

import org.ylan.common.convention.errorcode.IErrorCode;

/**
 * 分组错误码定义定义
 *
 * @author ylan
 */

public enum GroupErrorCodeEnum implements IErrorCode {

    GROUP_SAVE_ERROR("B000301","分组记录新增失败"),

    GROUP_NAME_EXISTS_ERROR("B000302","分组名称已存在"),

    GROUP_LIST_NOT_FOUND_ERROR("B000303","用户分组记录不存在"),

    GROUP_HAS_SHORT_LINK("B000304","该分组下存在短链接，无法删除"),

    GROUP_HAS_RECYCLE_BIN_SHORT_LINK_ERROR("B000305","该分组下存在回收站中的短链接，无法删除"),

    GROUP_DELETE_ERROR("B000306","分组记录删除失败");

    private final String code;

    private final String message;

    GroupErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}