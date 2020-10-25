package com.weweibuy.webuy.learning.flowable.mvc;

import org.flowable.common.engine.impl.identity.Authentication;
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
 * @date 2020/10/24 16:41
 **/
@Component
@Order(1)
public class AuthenticationUserFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication.setAuthenticatedUserId("1");
        filterChain.doFilter(request, response);
    }
}
