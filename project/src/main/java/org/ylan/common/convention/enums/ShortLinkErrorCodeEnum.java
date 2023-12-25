package org.ylan.common.convention.enums;

import org.ylan.common.convention.errorcode.IErrorCode;

/**
 * 短链接错误码枚举定义
 *
 * @author ylan
 */

public enum ShortLinkErrorCodeEnum implements IErrorCode {

    SHORT_LINK_GENERATE_ERROR("B000401","短链接频繁生成，请稍后再试"),

    SHORT_LINK_SAVE_ERROR("B000402","短链接保存失败"),

    SHORT_LINK_GENERATE_REPEAT_ERROR("B000403","短链接生成重复");

    private final String code;

    private final String message;

    ShortLinkErrorCodeEnum(String code, String message) {
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