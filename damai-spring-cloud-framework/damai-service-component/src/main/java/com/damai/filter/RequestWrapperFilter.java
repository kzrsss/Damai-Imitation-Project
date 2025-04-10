package com.damai.filter;

import com.damai.request.CustomizeRequestWrapper;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program:
 * @description: request包装过滤器
 * @author:  旷智仁
 **/
public class RequestWrapperFilter extends OncePerRequestFilter {
    
    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, 
                                    final FilterChain filterChain) throws ServletException, IOException {
        CustomizeRequestWrapper requestWrapper = new CustomizeRequestWrapper(request);
        filterChain.doFilter(requestWrapper,response);
    }
}
