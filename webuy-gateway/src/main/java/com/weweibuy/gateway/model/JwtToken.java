package com.weweibuy.gateway.model;

import lombok.Data;

import java.util.Set;

/**
 * @ClassName JwtToken
 * @Description
 * @Author durenhao
 * @Date 2019/1/12 11:02
 **/
@Data
public class JwtToken {

    private String access_token;

    private String token_type;

    private String refresh_token;

    private Integer expires_in;

    private Set<String> scope;

    private Object jti;

}
