package com.weweibuy.webuy.auth.security;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.webuy.user.client.UserClient;
import com.weweibuy.webuy.user.common.model.po.WebuyUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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

    /**
     * 这里直接注入feignCilent 会导致容器刷新两次,bean顺序加载错误
     * 使用懒加载防止,影响正常加载顺序
     */
    @Autowired
    @Lazy
    private UserClient userClient;

    /**
     * 表单登录
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("【安全服务】：登录用户名{}", username);
        if(true){
            return new User("tom", encoder.encode("123456"), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        }
        CommonDataResponse<WebuyUser> userWebResult = userClient.loadUserByUsername(username);
        return new User(username, ((WebuyUser) userWebResult.getData()).getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));

    }

    /**
     * 社交登录
     *
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
