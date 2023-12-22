package org.ylan.common.convention.exception;

import org.ylan.common.convention.enums.BaseErrorCodeEnum;
import org.ylan.common.convention.errorcode.IErrorCode;

/**
 * 客户端异常
 *
 * @author ylan
 */

public class ClientException extends AbstractException {

    public ClientException(String message) {
        this(message, null, BaseErrorCodeEnum.CLIENT_ERROR);
    }

    public ClientException(IErrorCode errorCode) {
        this(null, null, errorCode);
    }

    public ClientException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ClientException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ClientException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}