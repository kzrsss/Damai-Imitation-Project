package com.damai.filter;


import com.damai.util.StringUtil;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.damai.constant.Constant.TRACE_ID;

/**
 * @program:
 * @description: 链路过滤器
 * @author:  旷智仁
 **/

public class RequestParamContextFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String traceId = request.getHeader(TRACE_ID);
        if (StringUtil.isNotEmpty(traceId)){
            MDC.put(TRACE_ID,traceId);
        }
        try {
            filterChain.doFilter(request, response);
        }finally {
            MDC.remove(TRACE_ID);
        }
    }
}
