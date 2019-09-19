package com.weweibuy.webuy.learning.spring.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/9/19 21:01
 **/
@ApiModel(value = "用户信息" )
@Data
public class UserInfo extends PageQuery  {

    @ApiModelProperty(value = "姓名", example = "tom", required = true)
    private String name;

    @ApiModelProperty(value = "狗名字集合")
    private List<String> dogNameList;

    @ApiModelProperty(value = "公司信息")
    private List<Company> companyList;

    @ApiModelProperty(value = "狗集合")
    private Dog dog;

    @Data
    public static class Company {

        @ApiModelProperty(value = "名称", example = "jd")
        private String companyName;

        @ApiModelProperty(value = "地址", example = "上海" )
        private String companyAddr;

    }


}
