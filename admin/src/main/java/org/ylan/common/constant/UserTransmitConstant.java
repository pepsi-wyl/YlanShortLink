package org.ylan.common.constant;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 用户传输常量
 *
 * @author ylan
 */
public class UserTransmitConstant {

    public static final String USER_NAME = "username";

    public static final String TOKEN = "token";

    public static final List<String> IGNORE_URI = Lists.newArrayList(
            "/api/short-link/admin/v1/user/login",
            "/api/short-link/admin/v1/user/has-username"
    );
}