package org.ylan.common.log;

import cn.hutool.core.lang.UUID;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

import static org.ylan.common.constant.LogsConstant.TRACE_ID;


/**
 * 请求日志拦截器
 *
 * @author ylan
 */

public class LogsInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 如果有上层调用就用上层的TRACE_ID
        String traceId = request.getHeader(TRACE_ID);
        // 如果没有上层调用，就生成一个TRACE_ID
        if (Objects.isNull(traceId)) {
            traceId = UUID.randomUUID().toString().replace("-","");
        }
        // 设置进MDC
        MDC.put(TRACE_ID, traceId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 移除MDC
        MDC.remove(TRACE_ID);
    }

}