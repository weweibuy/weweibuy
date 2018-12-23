package com.weweibuy.auth.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * 处理社交登录，成功之后用户注册
 * @ClassName IConnectionSignUp
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 20:41
 **/
@Component
public class IConnectionSignUp implements ConnectionSignUp {

    /**
     * 使用返回值作为id注册用户
     * @param connection
     * @return
     */
    @Override
    public String execute(Connection<?> connection) {
        return connection.getKey().getProviderUserId();
    }
}
