package com.weweibuy.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 队 Auth 工程的限流
 * @ClassName AuthRateLimiterFilter
 * @Description
 * @Author durenhao
 * @Date 2019/4/4 23:34
 **/
@Slf4j
@Component
public class AuthRateLimiterFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 9;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        return null;
    }
}
