package com.weweibuy.webuy.learning.spring.advice;

import com.weweibuy.webuy.learning.spring.model.event.LogEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
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

    private final ThreadPoolTaskExecutor taskExecutor;

    private final ApplicationContext applicationContext;

    public TraceFilter(ThreadPoolTaskExecutor taskExecutor, ApplicationContext applicationContext) {
        this.taskExecutor = taskExecutor;
        this.applicationContext = applicationContext;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        long l = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        log.info("请求耗时: {}, 请求地址: {}", System.currentTimeMillis() - l, request.getRequestURI());

        taskExecutor.execute(() -> {
            LogEvent user = LogEvent.builder().path(request.getRequestURI()).userName(request.getHeader("user")).time(System.currentTimeMillis() - l).build();
            applicationContext.publishEvent(user);
        });
    }
}
