package com.weweibuy.auth.security;

import com.weweibuy.user.client.UserClient;
import com.weweibuy.user.common.model.dto.UserWebResult;
import com.weweibuy.user.common.model.po.WebuyUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @ClassName IUserDetailService
 * @Description
 * @Author durenhao
 * @Date 2018/12/15 11:26
 **/
@Component
@Slf4j
public class IUserDetailService implements UserDetailsService, SocialUserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserClient userClient;

    /**
     *
     * 表单登录
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("【安全服务】：登录用户名{}", username);
        UserWebResult userWebResult = userClient.loadUserByUsername(username);
        if(userWebResult.getCode().equals(1)){
            return new User(username, encoder.encode(((WebuyUser)userWebResult.getData()).getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        }
        return null;
    }

    /**
     * 社交登录
     * @param userId
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        log.info("【社交登录】用户id {}", userId);
        return null;
    }


}
