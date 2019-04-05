package com.weweibuy.webuy.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @ClassName TestHearFilter
 * @Description
 * @Author durenhao
 * @Date 2019/1/6 18:59
 **/
@Component
@Slf4j
public class TestHearFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        Enumeration<String> authorization = request.getHeaders("Authorization");
        while (authorization.hasMoreElements()){
            System.err.println(authorization.nextElement());
        }
        log.info("TestHearFilter 请求头:{} ", request.getHeader("Authorization"));
        return null;
    }
}
