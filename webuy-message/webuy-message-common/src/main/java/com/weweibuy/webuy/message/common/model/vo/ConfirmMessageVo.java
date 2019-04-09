package com.weweibuy.webuy.message.common.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author durenhao
 * @date 2019/2/9 22:15
 **/
@Data
@ApiModel("消息信息载体")
public class ConfirmMessageVo {

    /**
     * 消息id
     */
    @NotNull(message = "消息id不能为空")
    @ApiModelProperty(value = "消息id;", example = "3131710141574070272", required = true)
    private Long id;

    /**
     * 消息id
     */
    @NotBlank(message = "消息correlationId不能为空")
    @Length(min = 0, max = 63, message = "消息correlationId长度错误")
    @ApiModelProperty(value = "消息id;不能为空最大长度63", example = "21743da6-e913-4495-8b8c-60c2c3af084b", required = true)
    private String messageCorrelationId;


}
