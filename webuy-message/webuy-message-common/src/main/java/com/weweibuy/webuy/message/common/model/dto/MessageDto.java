package com.weweibuy.webuy.message.common.model.dto;

import com.weweibuy.webuy.message.common.model.po.WebuyMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName MessageDto
 * @Description
 * @Author durenhao
 * @Date 2019/2/31 23:14
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("消息输出信息载体")
@Builder
public class MessageDto {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "消息id")
    private String messageCorrelationId;

    @ApiModelProperty(value = "消息发送次数")
    private Byte messageSendTime;

    @ApiModelProperty(value = "消息是否死亡")
    private Byte isDead;

    @ApiModelProperty(value = "消息状态")
    private Byte messageStatus;


    public static MessageDto conventPoToDto(WebuyMessage webuyMessage){
        MessageDto messageDto = new MessageDto();
        BeanUtils.copyProperties(webuyMessage, messageDto);
        return messageDto;
    }

    public static List<MessageDto> conventListPoToDto(List<WebuyMessage> list){
        return list.stream()
                .map(webuyMessage -> MessageDto.conventPoToDto(webuyMessage))
                .collect(Collectors.toList());
    }

}
