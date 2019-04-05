package com.weweibuy.webuy.auth.core.filter;

import com.weweibuy.webuy.auth.core.config.eum.ValidateCodeType;
import com.weweibuy.webuy.auth.core.config.properties.SecurityProperties;
import com.weweibuy.webuy.auth.core.exception.ValidateCodeException;
import com.weweibuy.webuy.auth.core.validate.code.ValidateCodeProcessor;
import com.weweibuy.webuy.auth.core.validate.code.ValidateCodeProcessorHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 验证码过滤器
 * @ClassName ValidateCodeFilter
 * @Description
 * @Author durenhao
 * @Date 2018/12/16 14:51
 **/
@Component
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    @Autowired
    private SecurityProperties securityProperties;

    private final Map<String, ValidateCodeType> urlMap = new HashMap<>();


    @Override
    public void afterPropertiesSet(){
        urlMap.put(securityProperties.getLogin().getMobileLoginUrL(), ValidateCodeType.SMS);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        log.debug("请求的url{}, 方法{}",httpServletRequest.getRequestURI(), httpServletRequest.getMethod());
        try {
            ValidateCodeProcessor validateCodeProcessor = getValidateCodeProcessor(httpServletRequest);
            if(validateCodeProcessor != null){
                validateCodeProcessor.validate(new ServletWebRequest(httpServletRequest, httpServletResponse));
            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }catch (ValidateCodeException exception){
            authenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, exception);
        }
    }

    /**
     * 根据请求的url获取验证码的处理器，如果不需要验证码处理返回null
     * @param request
     * @return
     */
    private ValidateCodeProcessor getValidateCodeProcessor(HttpServletRequest request){
        for(String url : urlMap.keySet()){
            if(url.equals(request.getRequestURI())){
                return validateCodeProcessorHolder.getValidateCodeProcessor(urlMap.get(url));
            }
        }
        return null;
    }

}
