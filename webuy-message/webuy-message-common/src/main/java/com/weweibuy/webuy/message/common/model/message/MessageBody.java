package com.weweibuy.webuy.message.common.model.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 消息体
 *
 * @author durenhao
 * @date 2019/4/11 22:05
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageBody<T> {

    /**
     * 消息id
     */
    private Long id;

    /**
     * correlationId
     */
    private String messageCorrelationId;

    /**
     * 数据
     */
    private T data;

}
