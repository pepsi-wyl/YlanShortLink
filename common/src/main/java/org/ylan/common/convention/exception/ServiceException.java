package org.ylan.common.convention.exception;

import org.ylan.common.convention.enums.BaseErrorCodeEnum;
import org.ylan.common.convention.errorcode.IErrorCode;

import java.util.Optional;

/**
 * 服务端异常
 *
 * @author ylan
 */

public class ServiceException extends AbstractException {

    public ServiceException(String message) {
        this(message, null, BaseErrorCodeEnum.SERVICE_ERROR);
    }

    public ServiceException(IErrorCode errorCode) {
        this(null, errorCode);
    }

    public ServiceException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ServiceException(String message, Throwable throwable, IErrorCode errorCode) {
        super(Optional.ofNullable(message).orElse(errorCode.message()), throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}