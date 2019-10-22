package com.weweibuy.webuy.learning.event.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author durenhao
 * @date 2019/10/22 21:28
 **/
@Component
@Order(100)
public class LogFilter extends OncePerRequestFilter {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        THREAD_LOCAL.set("123");
        logger.info(" log filer running ,....");
        try {
            filterChain.doFilter(request, response);
        }finally {
            THREAD_LOCAL.remove();
        }

    }
}
