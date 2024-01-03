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

    GROUP_LIST_NOT_FOUND_ERROR("B000303","用户分组记录不存在");

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