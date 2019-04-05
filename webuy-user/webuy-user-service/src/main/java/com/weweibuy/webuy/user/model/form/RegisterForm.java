package com.weweibuy.webuy.user.model.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 注册表单
 * @ClassName RegisterForm
 * @Description
 * @Author durenhao
 * @Date 2019/1/20 11:18
 **/
@Data
@ApiModel
public class RegisterForm {

    @NotBlank
    @ApiModelProperty
    private String username;

    @NotBlank
    @ApiModelProperty
    private String phone;

    @NotBlank
    @ApiModelProperty
    private String code;

    @NotBlank
    @ApiModelProperty
    private String password;

}
