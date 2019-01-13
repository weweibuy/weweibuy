package com.weweibuy.auth.security;

import com.alibaba.fastjson.JSONObject;
import com.weweibuy.auth.config.AuthorizationServerConfig;
import com.weweibuy.auth.core.config.eum.LoginResponseType;
import com.weweibuy.auth.core.config.properties.SecurityProperties;
import com.weweibuy.auth.model.dto.JwtResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;

/**
 * 登录成功的处理方法
 * @ClassName IAuthenticationSuccessHandler
 * @Description
 * @Author durenhao
 * @Date 2018/12/15 20:02
 **/
@Component
@Order(Integer.MAX_VALUE)
@Slf4j
public class IAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private SecurityProperties securityProperties;

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Autowired
    private ClientDetailsService clientDetailsService;

    private AuthorizationServerTokenServices tokenServices;


    /**
     * TODO 使用网关代理后应写入TOKEN(可能是由于跨域的Session,有待弄清楚)
     * TODO 写入TOKEN可以使用OAuth的/oauth/token 这里已经有用户的authentication需要将authentication转为TOKEN
     * @param httpServletRequest
     * @param httpServletResponse
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        OAuth2AccessToken accessToken = createOAuth2AccessToken(httpServletRequest, authentication);
        JwtResponseDto jwtResponseDto = convertOAuth2AccessTokenToJwtResponse(accessToken);
        Cookie cookie = new Cookie("Authorization", URLEncoder.encode(jwtResponseDto.getAccess_token(), "UTF-8"));
        cookie.setMaxAge(3600 * 24);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
        boolean accept = httpServletRequest.getHeader("Accept").contains("text/html");
        if(!accept && LoginResponseType.JSON.equals(securityProperties.getLoginResponseType())){
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(JSONObject.toJSONString(jwtResponseDto));
        }else{
            SavedRequest savedRequest = requestCache.getRequest(httpServletRequest, httpServletResponse);
            clearAuthenticationAttributes(httpServletRequest);
            String[] redirect_urls = savedRequest.getParameterValues("redirect_url");
            requestCache.removeRequest(httpServletRequest, httpServletResponse);
            if(redirect_urls != null && StringUtils.isNotBlank(redirect_urls[0])){
                getRedirectStrategy().sendRedirect(httpServletRequest, httpServletResponse, redirect_urls[0]);
            }else {
                httpServletResponse.sendRedirect("http://localhost:8080/auth/index.html");

            }
        }
    }

    private OAuth2AccessToken createOAuth2AccessToken(HttpServletRequest request,  Authentication authentication) throws IOException {
        String client_id;
        String client_secret;
        if(isBrowseRequest(request)){
            client_id = "browser";
            client_secret = "123";
        }else {
            String header = request.getHeader("Authorization");
            if (header == null || !header.startsWith("Basic ")) {
                throw new UnapprovedClientAuthenticationException("请求头中没有client_id 信息");
            }
            // 获取请求投中的 client_id 和 client_secret
            String[] tokens = extractAndDecodeHeader(header, request);
            assert tokens.length == 2;
            client_id = tokens[0];
            client_secret = tokens[1];
        }

        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(client_id);
        if(clientDetails == null){
            throw new UnapprovedClientAuthenticationException("客户端信息不存在");
        }else if(clientDetails.getClientSecret().equals(client_secret)){
            throw new UnapprovedClientAuthenticationException("客户端信息密码错误");
        }
        TokenRequest tokenRequest = new TokenRequest(new HashMap<String, String>(), client_id, clientDetails.getScope(), "abc");
        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
        OAuth2AccessToken accessToken = tokenServices.createAccessToken(oAuth2Authentication);
        return accessToken;
    }


    public boolean isBrowseRequest(HttpServletRequest request){
        return request.getRequestURI().equals("/authentication/form");
    }

    private String[] extractAndDecodeHeader(String header, HttpServletRequest request)
            throws IOException {

        byte[] base64Token = header.substring(6).getBytes("UTF-8");
        byte[] decoded;
        try {
            decoded = Base64.getDecoder().decode(base64Token);
        }
        catch (IllegalArgumentException e) {
            throw new BadCredentialsException(
                    "Failed to decode basic authentication token");
        }
        String token = new String(decoded, "UTF-8");
        int delim = token.indexOf(":");
        if (delim == -1) {
            throw new BadCredentialsException("Invalid basic authentication token");
        }
        return new String[] { token.substring(0, delim), token.substring(delim + 1) };
    }

    public JwtResponseDto convertOAuth2AccessTokenToJwtResponse(OAuth2AccessToken oAuth2AccessToken){
        JwtResponseDto jwtResponse = new JwtResponseDto();
        jwtResponse.setAccess_token(oAuth2AccessToken.getValue());
        jwtResponse.setExpires_in(oAuth2AccessToken.getExpiresIn());
        jwtResponse.setJti(oAuth2AccessToken.getAdditionalInformation().get("jti"));
        jwtResponse.setScope(oAuth2AccessToken.getScope());
        jwtResponse.setRefresh_token(oAuth2AccessToken.getRefreshToken().getValue());
        jwtResponse.setToken_type(oAuth2AccessToken.getTokenType());
        return jwtResponse;
    }


    /**
     * AuthorizationServerTokenServices虽然是Spring管理的bean但是在这里直接注入
     * 会导致Oauth的组件加载顺序错误,使endpoints 无法持有 AuthenticationManager进而不支持password模式
     * 如果直接在endpoints {@link AuthorizationServerConfig} 中使用 @Bean AuthenticationManager  @Bean DefaultTokenServices 然后getBean
     * 这样的配置给endpoints 虽然手动保证了bean的加载顺序 但是会导致,即使给 endpoints 加了JwtTokenStore 和 JwtTokenConverter
     * JwtTokenStore 也不可用
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        AuthorizationServerTokenServices tokenServices = applicationContext.getBean(AuthorizationServerTokenServices.class);
        this.tokenServices = tokenServices;
    }

}
