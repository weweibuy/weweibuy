package com.weweibuy.gateway.authentication.cookie;

import com.weweibuy.gateway.authentication.IAuthenticationEntryPoint;
import com.weweibuy.gateway.authentication.exception.CookieAuthenticationInvalidException;
import com.weweibuy.gateway.model.JwtToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 基于cookie进行验证认证过滤器
 * @ClassName CookieAuthenticationFilter
 * @Description
 * @Author durenhao
 * @Date 2019/1/10 22:50
 **/
@Component
@Slf4j
public class CookieAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private IAuthenticationEntryPoint authenticationEntryPoint;

    private static final String defaultFilterProcessesUrl = "/**";

    private AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource = new OAuth2AuthenticationDetailsSource();

    private AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // OAuth2AuthenticationProcessingFilter 已经认证成功
        if(authentication != null){
            filterChain.doFilter(request, response);
        }else {

            // 这里需要捕获token失效的异常,防止无限重定向
            try {
                // 解析cookie中的authentication
                authentication = extract(request);

                if (authentication != null) {
                    request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_VALUE, authentication.getPrincipal());
                    if (authentication instanceof AbstractAuthenticationToken) {
                        AbstractAuthenticationToken needsDetails = (AbstractAuthenticationToken) authentication;
                        needsDetails.setDetails(authenticationDetailsSource.buildDetails(request));
                    }
                    Authentication authResult = authenticationManager.authenticate(authentication);
                    SecurityContextHolder.getContext().setAuthentication(authResult);
                }
                filterChain.doFilter(request, response);
            }catch (InvalidTokenException e){
                log.info("cookie 中的Authentication信息已经失效");
                SecurityContextHolder.clearContext();
                removeCookieAuthentication(request);
                throw new CookieAuthenticationInvalidException(e.getMessage());
            }
        }
    }

    public PreAuthenticatedAuthenticationToken extract(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies == null){
            return null;
        }
        JwtToken jwtToken = null;
        String jwtTokenStr = null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("Authorization")){
                jwtTokenStr = cookie.getValue();
            }
        }
        if(StringUtils.isBlank(jwtTokenStr)){
            return null;
        }
        PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(jwtTokenStr, "");
        return authentication;
    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return false;
        }
        return true;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    private void removeCookieAuthentication(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("Authorization")){
                cookie.setMaxAge(0);
            }
        }
    }

}
