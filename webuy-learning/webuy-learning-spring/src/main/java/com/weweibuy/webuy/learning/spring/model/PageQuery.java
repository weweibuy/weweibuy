package com.weweibuy.webuy.learning.spring.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author durenhao
 * @date 2019/9/19 21:03
 **/
@Data
@ApiModel("分页查询对象")
public class PageQuery {

    @ApiModelProperty(value = "页数", notes = "最大10")
    private Integer page;

    @ApiModelProperty(value = "每页大小", notes = "最大50")
    private Integer size;


}
