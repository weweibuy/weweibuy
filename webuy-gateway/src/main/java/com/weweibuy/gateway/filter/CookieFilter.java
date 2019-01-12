package com.weweibuy.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
public class CookieFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(int i = 0; i < cookies.length; i++){
                Cookie cookie = cookies[i];
                log.info("cookie 名: {} , 值: {}", cookie.getName(), cookie.getValue());
            }
        }else {
            filterChain.doFilter(request, response);
        }

    }
}
