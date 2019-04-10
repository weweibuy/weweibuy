package com.weweibuy.webuy.message.service;

/**
 * @author durenhao
 * @date 2019/2/9 22:41
 **/
public interface MessageAckManager {

    /**
     * 处理Nack的消息如果消息发送了 3次则直接死亡
     * @param messageCorrelationId
     */
    void execMessageNack(String messageCorrelationId);


}
