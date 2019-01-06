package com.weweibuy.gateway.filter;

import com.weweibuy.gateway.servlet.ModifyHttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对于浏览器访问,直接给其添加一个client_id
 * @ClassName ClientIdFilter
 * @Description
 * @Author durenhao
 * @Date 2019/1/6 17:42
 **/
@Slf4j
@Component
public class ClientIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        ModifyHttpServletRequestWrapper httpServletRequestWrapper = null;
        log.info("ClientIdFilter 拦截到请求:{} ", request.getRequestURI());
        log.info("请求头的 Authorization 信息 {} ", request.getHeader("Authorization"));
        String agent = request.getHeader("user-agent");
        log.info("请求设备: {}", agent);
        //客户端类型常量
        String type = "";
        if(agent.contains("iPhone")||agent.contains("iPod")||agent.contains("iPad")){
            type = "ios";
        } else if(agent.contains("Android") || agent.contains("Linux")) {
            type = "apk";
        } else if(agent.indexOf("micromessenger") > 0){
            type = "wx";
        }else {
            type = "pc";
            if(StringUtils.isBlank(request.getHeader("Authorization"))){
                log.info("Authorization 信息为空, 设置 client_id 信息");
                httpServletRequestWrapper = new ModifyHttpServletRequestWrapper(request);
                httpServletRequestWrapper.putHeader("Authorization", "Basic d2VidXk6d2VidXkxMjM=");
                httpServletRequestWrapper.putHeader("Access-Control-Allow-Origin", "*");
                httpServletRequestWrapper.putHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
                httpServletRequestWrapper.putHeader("Access-Control-Allow-Headers", "Content-Type");
            }
        }
        if(httpServletRequestWrapper != null){
            log.info("设置后的请求头: {}", httpServletRequestWrapper.getHeader("Authorization"));
            filterChain.doFilter(httpServletRequestWrapper, response);
        }else {
            filterChain.doFilter(request, response);
        }
    }
}
