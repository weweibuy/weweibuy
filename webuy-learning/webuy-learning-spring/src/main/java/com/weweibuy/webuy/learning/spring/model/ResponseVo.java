package com.weweibuy.webuy.learning.spring.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author durenhao
 * @date 2019/4/25 22:13
 **/
@Data
@ToString
public class ResponseVo {

    private String code;

    private String msg;

    private String errorCode;
}
