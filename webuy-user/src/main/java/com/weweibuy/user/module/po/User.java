package com.weweibuy.user.module.po;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName User
 * @Description
 * @Author durenhao
 * @Date 2018/11/25 12:00
 **/
@Data
public class User {

    @NotBlank
    private String name;

    @NotNull
    private Integer age;

}
