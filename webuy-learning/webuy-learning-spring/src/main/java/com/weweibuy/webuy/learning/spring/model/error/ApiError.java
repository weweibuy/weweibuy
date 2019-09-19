package com.weweibuy.webuy.learning.spring.model.error;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author durenhao
 * @date 2019/9/19 23:25
 **/
@Data
@ApiModel("错误响应")
public class ApiError {

    @ApiModelProperty("错误响应码")
    private String code;

    @ApiModelProperty("错误响应信息")
    private String msg;

}
