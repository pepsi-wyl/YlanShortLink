package org.ylan.common.convention.exception;


import org.ylan.common.convention.enums.BaseErrorCodeEnum;
import org.ylan.common.convention.errorcode.IErrorCode;

/**
 * 远程服务调用异常
 *
 * @author ylan
 */

public class RemoteException extends AbstractException {

    public RemoteException(String message) {
        this(message, null, BaseErrorCodeEnum.REMOTE_ERROR);
    }

    public RemoteException(IErrorCode errorCode) {
        this(null, null, errorCode);
    }

    public RemoteException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public RemoteException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}