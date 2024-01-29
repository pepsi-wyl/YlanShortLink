package org.ylan.common.convention.enums;

import org.ylan.common.convention.errorcode.IErrorCode;

/**
 * 用户错误码定义
 *
 * @author ylan
 */

public enum UserErrorCodeEnum implements IErrorCode {

    USER_NULL("B000200", "用户记录不存在"),

    USER_NAME_EXIST("B000201", "用户名已存在"),

    USER_EXIST("B000202", "用户记录已存在"),

    USER_SAVE_ERROR("B000203", "用户记录新增失败"),

    USER_UPDATE_ERROR("B000204","用户记录更新失败"),

    USER_LOGIN_ERROR("B000205","用户登录失败,用户名或密码错误"),

    USER_REPEAT_LOGIN_ERROR("B000206","用户重复登录错误"),

    USER_LOGOUT_ERROR("B000207","用户登出失败,用户未登录"),

    USER_LOGOUT_UPDATE_ERROR("B000208","用户登出失败,用户记录更新失败"),

    USER_NOT_LOGIN_ERROR("B000209","用户未登录错误");

    private final String code;

    private final String message;

    UserErrorCodeEnum(String code, String message) {
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