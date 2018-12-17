package com.weweibuy.auth.core.authentication.mobile;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @ClassName SmsCodeAuthenticationProvider
 * @Description
 * @Author durenhao
 * @Date 2018/12/16 14:27
 **/
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsCodeAuthenticationToken smsCodeAuthenticationToken = (SmsCodeAuthenticationToken) authentication;

        // 通过UserDetails进行信息认证
        UserDetails userDetails = userDetailsService.loadUserByUsername((String) authentication.getPrincipal());
        if(userDetails == null){ // 认证不通过
            throw new InternalAuthenticationServiceException("无法获取用户信息");
        }
        // 通过认证重新创建已认证的 AuthenticationToken
        SmsCodeAuthenticationToken authenticatedToken = new SmsCodeAuthenticationToken(userDetails, userDetails.getAuthorities());
        // 将之间的request，response 信息传给已认证的AuthenticationToken
        authenticatedToken.setDetails(smsCodeAuthenticationToken.getDetails());
        return authenticatedToken;
    }

    /**
     * 判断Provider是否支持此种类型的Token
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
