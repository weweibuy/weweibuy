package com.weweibuy.webuy.message.amqp.impl;

import com.weweibuy.webuy.message.amqp.MessageSender;
import com.weweibuy.webuy.message.common.model.po.WebuyMessage;
import com.weweibuy.webuy.message.service.MessageManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/2/8 23:22
 **/
@Slf4j
@Component
public class DefaultMessageSender implements MessageSender, InitializingBean {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageManager messageManager;


    /**
     * confirmCallback会在下面3中情况回调：
     *  消息已经路由
     *    (1)消息送达指定Queue回调 ACK=true;
     *    (2)交换机错误回调 ACK=false;
     *    (3)returnCallback回调完成之后，ACK=true;
     */
    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            if(ack){
                log.error("confirmCallback:{}", correlationData.getId());
            }else {
                messageManager.execMessageNack(correlationData.getId());
            }
        }
    };

    /**
     * A callback for returned messages.
     * 消息无法路由
     * returnCallback 是当RoutingKey错误broker无法将消息送到指定队列的回调，
     *   注意：当returnCallback执行完成后会跟着执行confirmCallback且ACK=true
     */
    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
            MessageProperties properties = message.getMessageProperties();
            String id = properties.getCorrelationId();
            messageManager.execMessageNack(id);
        }
    };

    @Override
    public void send(WebuyMessage message) {
        rabbitTemplate.convertAndSend(message.getMessageExchange(), message.getMessageRoutingKey(),
                message.getMessageBoby(), new CorrelationData(message.getMessageCorrelationId()));
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
    }
}
