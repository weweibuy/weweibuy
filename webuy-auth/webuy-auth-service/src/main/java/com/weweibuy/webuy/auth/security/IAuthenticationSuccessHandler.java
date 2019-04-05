package com.weweibuy.webuy.auth.security;

import com.alibaba.fastjson.JSONObject;
import com.weweibuy.webuy.auth.config.AuthorizationServerConfig;
import com.weweibuy.webuy.auth.core.config.properties.SecurityProperties;
import com.weweibuy.webuy.auth.model.dto.JwtResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
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
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
public class IAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private SecurityProperties securityProperties;

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Resource(name = "defaultAuthorizationServerTokenServices")
    @Lazy
    private AuthorizationServerTokenServices tokenServices;


    /**
     * 认证成功后的处理逻辑
     * TODO 在这里使用zuul 网关代理资源服务器,只是在认证服务器上做了登录,写入然后发放令牌
     * TODO 并没有在zuul上(或者cilent上)登录;  那么如果使用zuul统一代理所有微服务,可能client也将成为资源服务
     * TODO 这就导致oauth 协议中的角色混乱(zuul也代理了 认证服务;) 这里是否需要将个个角色单独分离出来,需要根据以后开发情况决定
     * TODO 目前也无法支持第三方 client 登录(取消 /login的 requestCache)
     * @param httpServletRequest
     * @param httpServletResponse
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        // TODO 浏览器
        OAuth2AccessToken oAuth2AccessTokenForBrowse = createOAuth2AccessTokenForBrowse(httpServletRequest, authentication);
        JwtResponseDto jwtResponseDto = convertOAuth2AccessTokenToJwtResponse(oAuth2AccessTokenForBrowse);
        Cookie cookie = new Cookie("Authorization", URLEncoder.encode(jwtResponseDto.getAccess_token(), "UTF-8"));
        cookie.setMaxAge(3600 * 24);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        httpServletResponse.addCookie(cookie);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JSONObject.toJSONString(jwtResponseDto));
    }

    private OAuth2AccessToken createOAuth2AccessToken(HttpServletRequest request,  Authentication authentication) throws IOException {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Basic ")) {
            throw new UnapprovedClientAuthenticationException("请求头中没有client_id 信息");
        }
        // 获取请求投中的 client_id 和 client_secret
        String[] tokens = extractAndDecodeHeader(header, request);
        assert tokens.length == 2;
        String client_id = tokens[0];
        String client_secret = tokens[1];
        return createOAuth2AccessToken(client_id, client_secret, authentication);
    }


    private OAuth2AccessToken createOAuth2AccessTokenForBrowse(HttpServletRequest request,  Authentication authentication) throws IOException {
        String client_id = "browser";
        String client_secret = "123";
        return createOAuth2AccessToken(client_id, client_secret, authentication);
    }

    private OAuth2AccessToken createOAuth2AccessToken(String client_id, String client_secret, Authentication authentication){
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

    /**
     * 判断请求是否来自浏览器
     * @param request
     * @return
     */
    public boolean isBrowseRequest(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(request.getHeader("Accept").contains("text/html") &&
            request.getHeader("User-Agent").startsWith("Mozilla")){
            return true;
        }
        return false;
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
     * 注意: ApplicationListener<ContextRefreshedEvent> 只是容器刷新并非容器记载完成!!!
     * 注意:  使用懒加载模式也可以完美解决这种问题!!!
     * 注意:  关闭 cglib代理!!!!1
     *
     * @param event
     */
//    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("applicationContext 加载完成");
        ApplicationContext applicationContext = event.getApplicationContext();
        AuthorizationServerTokenServices tokenServices = applicationContext.getBean("defaultAuthorizationServerTokenServices", AuthorizationServerTokenServices.class);
        this.tokenServices = tokenServices;
    }

}
