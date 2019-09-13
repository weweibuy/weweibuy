package com.weweibuy.webuy.learning.spring.desensitization.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.weweibuy.webuy.learning.spring.desensitization.SensitiveData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author durenhao
 * @date 2019/9/12 22:26
 **/
@Slf4j
@Data
// @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // --> 指定json 风格
public class SensitiveUser {

    @JsonProperty("userName") // ---> 指定请求响应的字段 --> 可以覆盖 JsonNaming
    private String username;

    @SensitiveData
    private String password;

    private String phone;

    private Integer age;

    private String address;

    private String city;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
}
