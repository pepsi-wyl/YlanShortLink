package org.ylan.common.convention.errorcode;

/**
 * 平台错误码
 *
 * @author ylan
 */

public interface IErrorCode {

    /**
     * 错误码
     */
    String code();

    /**
     * 错误信息
     */
    String message();
}