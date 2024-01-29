package org.ylan.common.bit.user;

import cn.hutool.core.util.StrUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.IOException;

import static org.ylan.common.constant.UserTransmitConstant.*;


/**
 * 用户信息传输过滤器
 *
 * @author ylan
 */

@RequiredArgsConstructor
public class UserTransmitFilter implements Filter {

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String username = httpServletRequest.getHeader(USER_NAME);

        if (StrUtil.isNotBlank(username)) {
            // 获取用户信息
            String userId = httpServletRequest.getHeader(HTTP_HEADER_USER_ID);
            String realName = httpServletRequest.getHeader(HTTP_HEADER_USER_REAL_NAME);
            // 并设置UserContext上下文
            UserInfoDTO userInfoDTO = new UserInfoDTO(userId, username, realName);
            UserContext.setUser(userInfoDTO);
        }

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            UserContext.removeUser();
        }
    }
}