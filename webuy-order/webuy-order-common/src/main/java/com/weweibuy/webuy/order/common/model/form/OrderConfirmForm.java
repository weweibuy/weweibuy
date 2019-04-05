package com.weweibuy.webuy.order.common.model.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * 订单确认表单
 * @ClassName OrderConfirmForm
 * @Description
 * @Author durenhao
 * @Date 2019/2/8 21:55
 **/
@Data
@ApiModel("订单确认")
public class OrderConfirmForm {

    @NotNull(message = "订单号不能为空")
    @ApiModelProperty(value = "订单号", example = "1", required = true)
    private Long id;

    @NotNull(message = "用户id不能为空")
    @ApiModelProperty(value = "用户名id", example = "1", required = true)
    private Long userId;

    @NotNull(message = "商户id不能为空")
    @ApiModelProperty(value = "商户id", example = "1", required = true)
    private Long sellerId;

    /** 配送方式id */
    @NotNull(message = "配送方式id不能为空")
    @ApiModelProperty(value = "配送方式id", example = "1", required = true)
    private Long shippingId;

    @ApiModelProperty(value = "报价费用,默认不报价")
    private BigDecimal insureFee;

    @NotNull(message = "应付款金额不能为空")
    @Size(min = 0, message = "金额不能小于0元")
    @ApiModelProperty(value = "应付款金额", example = "100.00", required = true)
    private BigDecimal orderAmount;

    @NotNull(message = "商品id,不能违规为空")
    @ApiModelProperty(value = "商品id", example = "1", required = true)
    private Long itemId;

    @NotNull(message = "商品skuId不能为空")
    @ApiModelProperty(value = "商品skuId", example = "1", required = true)
    private Long skuId;

    @NotNull
    @Min(value = 1, message = "商品数量最小为1")
    @ApiModelProperty(value = "商品数量", example = "1", required = true)
    private Integer itemCount;

    @Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$")
    @ApiModelProperty(value = "收货人手机", example = "13800000000", required = true)
    private String receiverPhone;

    @NotBlank(message = "收货人姓名不能为空")
    @ApiModelProperty(value = "收货人姓名", example = "tom", required = true)
    private String receiverName;

    @NotBlank(message = "收货人地址不能为空")
    @ApiModelProperty(value = "收货人地址", example = "shanghai", required = true)
    private String receiverAdress;


}
