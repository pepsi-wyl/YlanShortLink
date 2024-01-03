package org.ylan.common.convention.result;

import org.ylan.common.convention.enums.BaseErrorCodeEnum;
import org.ylan.common.convention.exception.AbstractException;

import java.util.Optional;

/**
 * 全局返回对象构造器
 *
 * @author ylan
 */

public final class Results {

    /**
     * 构造成功响应
     */
    public static Result<Void> success() {
        return new Result<Void>()
                .setCode(Result.SUCCESS_CODE);
    }

    /**
     * 构造带返回数据的成功响应
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>()
                .setCode(Result.SUCCESS_CODE)
                .setData(data);
    }

    /**
     * 构建服务端失败响应
     */
    public static Result<Void> failure() {
        return new Result<Void>()
                .setCode(BaseErrorCodeEnum.SERVICE_ERROR.code())
                .setMessage(BaseErrorCodeEnum.SERVICE_ERROR.message());
    }

    /**
     * 通过 AbstractException 构建失败响应
     */
    public static Result<Void> failure(AbstractException abstractException) {
        String errorCode =
                Optional.ofNullable(abstractException.getErrorCode()).orElse(BaseErrorCodeEnum.SERVICE_ERROR.code());
        String errorMessage =
                Optional.ofNullable(abstractException.getErrorMessage()).orElse(BaseErrorCodeEnum.SERVICE_ERROR.message());
        return new Result<Void>()
                .setCode(errorCode)
                .setMessage(errorMessage);
    }

    /**
     * 通过 errorCode、errorMessage 构建失败响应
     */
    public static Result<Void> failure(String errorCode, String errorMessage) {
        return new Result<Void>()
                .setCode(errorCode)
                .setMessage(errorMessage);
    }
}