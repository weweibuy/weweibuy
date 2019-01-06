package com.weweibuy.auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * 格式化成功处理器响应的JwtResponse 格式
 * @ClassName JwtResponseDto
 * @Description
 * @Author durenhao
 * @Date 2019/1/6 14:22
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponseDto implements Serializable{

    private String access_token;

    private String token_type;

    private String refresh_token;

    private Integer expires_in;

    private Set<String> scope;

    private Object jti;

}
