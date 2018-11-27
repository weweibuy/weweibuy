package com.weweibuy.user.module.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName PhoneVerifyCodeVo
 * @Description
 * @Author durenhao
 * @Date 2018/11/26 23:12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneVerifyCodeVo {

    private Integer code;

    private Long timeStamp;

}
