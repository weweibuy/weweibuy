package com.weweibuy.webuy.message.common.model.vo;

import com.weweibuy.webuy.message.common.model.po.WebuyMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName MessageVo
 * @Description
 * @Author durenhao
 * @Date 2019/3/31 22:20
 **/
@Data
@ApiModel("消息信息载体")
public class MessageVo {

    /**
     * 消息id
     */
    @NotNull(message = "消息id长度错误")
    @ApiModelProperty(value = "消息id;不能为空最大长度63", example = "21743da6-e913-4495-8b8c-60c2c3af084b", required = true)
    private Long messageCorrelationId;

    @NotBlank(message = "消息体不能为空")
    @ApiModelProperty(value = "消息体json", example = "\"{username:tom, age:12}\"", required = true)
    private String messageBoby;

    @NotBlank(message = "消息队列不能为空")
    @ApiModelProperty(value = "消息队列", example = "order.queue", required = true)
    private String messageQueue;

    @NotBlank(message = "消息交换机不能为空")
    @ApiModelProperty(value = "消息交换机", example = "order.fanout.exchange", required = true)
    private String messageExchange;

    @ApiModelProperty(value = "消息路由键", example = "key.#")
    private String messageRoutingKey;

    public WebuyMessage conventToPo(){
        WebuyMessage webuyMessage = new WebuyMessage();
        BeanUtils.copyProperties(this, webuyMessage);
        return webuyMessage;
    }

}
