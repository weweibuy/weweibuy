package com.weweibuy.webuy.learning.spring.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/9/19 21:11
 **/
@Data
@ApiModel(description = "狗信息")
public class Dog {

    @ApiModelProperty(value = "狗名字")
    private String dogName;

    @ApiModelProperty(value = "狗ageList")
    private List<String> dogAges;


}
