package com.weweibuy.webuy.learing.mq.consumer.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2020/7/18 12:48
 **/
@Slf4j
@Component
public class SimplMessagePostProcessor implements MessagePostProcessor {

    private RabbitTemplate rabbitTemplate;

    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        log.info("message: {}", message.getBody());
        return message;
    }
}
