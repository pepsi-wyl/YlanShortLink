package org.ylan.common.bit.user;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.ylan.common.convention.exception.ClientException;
import org.ylan.common.convention.result.Results;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import static org.ylan.common.constant.RedisCacheConstant.LOGIN_PREFIX;
import static org.ylan.common.constant.UserTransmitConstant.*;
import static org.ylan.common.convention.enums.UserErrorCodeEnum.USER_TOKEN_FAIL;


/**
 * 用户信息传输过滤器
 *
 * @author ylan
 */

@RequiredArgsConstructor
public class UserTransmitFilter implements Filter {

    /**
     * StringRedisTemplate 操作redis
     */
    private final StringRedisTemplate stringRedisTemplate;


    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpServletRequest.getRequestURI();

        // 过滤不需要token的uri
        if (!IGNORE_URI.contains(requestURI)) {
            String method = httpServletRequest.getMethod();

            if (!(Objects.equals(requestURI, "/api/short-link/admin/v1/user") && Objects.equals(method, "POST"))) {

                // 获取请求中的 username 和 token
                String username = httpServletRequest.getHeader(USER_NAME);
                String token = httpServletRequest.getHeader(TOKEN);

                //  判断username和token是否为空
                if (!StrUtil.isAllNotBlank(username, token)) {
                    returnJson((HttpServletResponse) servletResponse, JSON.toJSONString(Results.failure(new ClientException(USER_TOKEN_FAIL))));
                    return;
                }

                // 尝试获取Redis中UserInfo信息
                Object userInfoJsonStr;
                try {
                    userInfoJsonStr = stringRedisTemplate.opsForHash().get(LOGIN_PREFIX + username, token);
                    if (Objects.isNull(userInfoJsonStr)) {
                        throw new ClientException(USER_TOKEN_FAIL);
                    }
                } catch (Exception ex) {
                    returnJson((HttpServletResponse) servletResponse, JSON.toJSONString(Results.failure(new ClientException(USER_TOKEN_FAIL))));
                    return;
                }

                // 解析UserInfo信息并设置UserContext上下文
                UserInfoDTO userInfoDTO = JSON.parseObject(userInfoJsonStr.toString(), UserInfoDTO.class);
                UserContext.setUser(userInfoDTO);
            }
        }

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            UserContext.removeUser();
        }
    }

    private void returnJson(HttpServletResponse response, String json) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
        } finally {
            if (writer != null){
                writer.close();
            }
        }
    }
}