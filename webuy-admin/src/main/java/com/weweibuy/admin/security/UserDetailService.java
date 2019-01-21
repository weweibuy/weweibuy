//package com.weweibuy.admin.security;
//
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
///**
// * @ClassName UserDetailService
// * @Description
// * @Author durenhao
// * @Date 2019/1/21 23:52
// **/
//@Component
//public class UserDetailService implements UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if(username.equals("admin")){
//            return new User(username, "ak402507979", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
//        }
//        return new User(username, "", null);
//    }
//}
