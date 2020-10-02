package com.weweibuy.webuy.gateway.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.RateLimiter;
import com.weweibuy.framework.common.core.model.dto.CommonCodeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 主限流过滤器
 * @ClassName RateLimiterFilter
 * @Description
 * @Author durenhao
 * @Date 2019/4/1 23:42
 **/
@Slf4j
@Component
public class PrimaryRateLimiterFilter extends OncePerRequestFilter {

    private static final RateLimiter RATE_LIMITER = RateLimiter.create(10);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        boolean b = RATE_LIMITER.tryAcquire();
        if(!b){
            log.info("网络限流，无法请求");
            ObjectMapper mapper = new ObjectMapper();
            CommonCodeResponse fail = CommonCodeResponse.requestLimit();
            String json = mapper.writeValueAsString(fail);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
        }else {
            filterChain.doFilter(request, response);
        }
    }
}
