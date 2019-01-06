package com.weweibuy.auth.security;

import com.alibaba.fastjson.JSONObject;
import com.weweibuy.auth.config.AuthorizationServerConfig;
import com.weweibuy.auth.core.config.eum.LoginResponseType;
import com.weweibuy.auth.core.config.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @Autowired
    private ClientDetailsService clientDetailsService;

    private AuthorizationServerTokenServices tokenServices;

    @PostConstruct
    public void init(){
        log.info("IAuthenticationSuccessHandler 加载了.........");
    }

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
        // authentication 包装这用户的信息
        if(LoginResponseType.JSON.equals(securityProperties.getLoginResponseType())){
            log.info("请求头: {}", httpServletRequest.getHeader("Authorization"));

            String header = httpServletRequest.getHeader("Authorization");

            if (header == null || !header.startsWith("Basic ")) {
                throw new UnapprovedClientAuthenticationException("请求头中没有client_id 信息");
            }
            // 获取请求投中的 client_id 和 client_secret
            String[] tokens = extractAndDecodeHeader(header, httpServletRequest);
            assert tokens.length == 2;
            String client_id = tokens[0];
            String client_secret = tokens[1];

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

            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(JSONObject.toJSONString(accessToken));

        }else{
            super.setDefaultTargetUrl("/index.html");
            super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);
        }
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
