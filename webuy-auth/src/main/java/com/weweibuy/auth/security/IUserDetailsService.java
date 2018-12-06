package com.weweibuy.auth.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 读取用户信息
 * @ClassName IUserDetailsService
 * @Description
 * @Author durenhao
 * @Date 2018/12/6 22:52
 **/
@Component
public class IUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 第三个参数是授权
        User user = new User(username, "pwd", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));

        user.isAccountNonLocked();// 是否锁定 需要在构造方法中指定
        user.isEnabled(); // 是否可用  需要在构造方法中指定
        return user;
    }
}
