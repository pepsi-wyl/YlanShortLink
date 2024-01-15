package org.ylan.common.bit.user;

import com.alibaba.fastjson2.JSON;
import com.google.common.collect.Lists;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.ylan.common.convention.exception.ClientException;
import org.ylan.common.convention.result.Results;
import org.ylan.config.UserFlowRiskControlConfiguration;

import java.io.PrintWriter;
import java.util.Objects;
import java.util.Optional;

import static org.ylan.common.convention.enums.BaseErrorCodeEnum.FLOW_LIMIT_ERROR;

/**
 * 用户操作流量风控过滤器
 *
 * @author ylan
 */

@Slf4j
@RequiredArgsConstructor
public class UserFlowRiskControlFilter implements Filter {

    /**
     * 操作Redis服务
     */
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 短链接流量风控配置文件
     */
    private final UserFlowRiskControlConfiguration userFlowRiskControlConfiguration;

    /**
     * Lua脚本位置
     */
    private static final String USER_FLOW_RISK_CONTROL_LUA_SCRIPT_PATH = "lua/user_flow_risk_control.lua";

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {

        // 读取短链接流量风控配置文件
        Boolean enable = userFlowRiskControlConfiguration.getEnable();
        if (Objects.isNull(enable)) enable = true;
        String timeWindow = userFlowRiskControlConfiguration.getTimeWindow();
        if (Objects.isNull(timeWindow)) timeWindow = "";
        Long maxAccessCount = userFlowRiskControlConfiguration.getMaxAccessCount();
        if (Objects.isNull(maxAccessCount)) maxAccessCount = 20L;

        // 如果开启
        if (enable) {
            // 读取Lua脚本
            DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
            redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource(USER_FLOW_RISK_CONTROL_LUA_SCRIPT_PATH)));
            redisScript.setResultType(Long.class);

            // 获取用户名
            String username = Optional.ofNullable(UserContext.getUsername()).orElse("otherReq");

            // 获取执行结果
            Long result = null;
            try {
                // 执行用户请求流量限制LUA脚本
                result = stringRedisTemplate.execute(redisScript, Lists.newArrayList(username), timeWindow);
            } catch (Throwable ex) {
                log.error("执行用户请求流量限制LUA脚本出错", ex);
                // 执行结果异常，则返回错误信息
                returnJson((HttpServletResponse) response, JSON.toJSONString(Results.failure(new ClientException(FLOW_LIMIT_ERROR))));
            }

            // 执行结果为空或者超出限额，则返回错误信息
            if (Objects.isNull(result) || result > maxAccessCount) {
                returnJson((HttpServletResponse) response, JSON.toJSONString(Results.failure(new ClientException(FLOW_LIMIT_ERROR))));
            }
        }

        // 执行过滤器
        filterChain.doFilter(request, response);
    }

    private void returnJson(HttpServletResponse response, String json) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(json);
        }
    }
}