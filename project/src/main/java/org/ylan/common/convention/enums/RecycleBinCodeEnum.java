package org.ylan.common.convention.enums;

import org.ylan.common.convention.errorcode.IErrorCode;

/**
 * 回收站错误码枚举定义
 *
 * @author ylan
 */

public enum RecycleBinCodeEnum implements IErrorCode {

    RECYCLE_BIN_SAVE_ERROR("B000501", "短链接移至回收站失败"),
    RECYCLE_BIN_RECOVER_ERROR("B000502","短链接移出回收站失败");

    private final String code;

    private final String message;

    RecycleBinCodeEnum(String code, String message) {
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