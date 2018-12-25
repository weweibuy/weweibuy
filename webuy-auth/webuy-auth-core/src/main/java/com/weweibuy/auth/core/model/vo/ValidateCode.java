package com.weweibuy.auth.core.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 验证码
 * @ClassName ValidateCode
 * @Description
 * @Author durenhao
 * @Date 2018/12/15 22:51
 **/
@Data
@NoArgsConstructor
public class ValidateCode implements Serializable {

    private String code;

    private LocalDateTime expireTime;

    public ValidateCode(String code, Long expireIn){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public boolean isExpired(){
        return LocalDateTime.now().isAfter(this.expireTime);
    }
}
