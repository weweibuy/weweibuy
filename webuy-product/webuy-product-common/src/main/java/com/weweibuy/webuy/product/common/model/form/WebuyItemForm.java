package com.weweibuy.webuy.product.common.model.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName WebuyItemForm
 * @Description
 * @Author durenhao
 * @Date 2019/2/6 19:44
 **/
@Data
@ApiModel("商品表单")
public class WebuyItemForm {

    @NotNull(message = "商品id不能为空")
    @ApiModelProperty(value = "商品id",example = "1",required = true)
    private Long itemId;

    @NotBlank(message = "商品名字不能为空")
    @Length(max = 20, message = "商品名字长度不能超过20")
    @ApiModelProperty(value = "商品名字",example = "iphone X",required = true)
    private String itemName;

    @NotBlank(message = "商品标题不能为空")
    @Length(max = 150, message = "商品标题长度不能超过150")
    @ApiModelProperty(value = "商品标题",example = "性能好",required = true)
    private String itemTitle;

    @NotNull(message = "店铺id不能为空")
    @ApiModelProperty(value = "店铺id",example = "1",required = true)
    private Long sellerId;

    @NotNull(message = "第一级商品分类id不能为空")
    @ApiModelProperty(value = "第一级商品分类id",example = "1",required = true)
    private Long category1Id;

    @NotNull(message = "第二级商品分类id不能为空")
    @ApiModelProperty(value = "第二级商品分类id",example = "1",required = true)
    private Long category2Id;

    @NotBlank(message = "预览图片不能为空")
    @Length(max = 150)
    @ApiModelProperty(value = "第二级商品分类id",example = "fdsfsd",required = true)
    private String previewImg;



}
