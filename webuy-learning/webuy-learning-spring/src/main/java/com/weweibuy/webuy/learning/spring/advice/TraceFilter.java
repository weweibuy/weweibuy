package com.weweibuy.webuy.learning.spring.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author durenhao
 * @date 2019/7/1 21:43
 **/
@Slf4j
@Component
public class TraceFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        long l = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        log.info("请求耗时: {}, 请求地址: {}", System.currentTimeMillis() - l, request.getRequestURI());
    }
}
