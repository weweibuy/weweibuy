package com.weweibuy.webuy.learing.mq.consumer.amqp;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/9/5 20:50
 **/
@Slf4j
@Component
public class SimpleConsumer2 {

    @RabbitListener(queues = "test_queue_02")
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception{
        long seqNo = channel.getNextPublishSeqNo();
        MessageHeaders headers = message.getHeaders();
        Object o = headers.get(AmqpHeaders.MESSAGE_COUNT);
        byte[] payload = (byte[])message.getPayload();
        Object id = message.getHeaders().getId();
        log.error("消息头ID : {}; message_count: {}", id, o);
        log.error("消息体是：{}", new String(payload));
        String correlationId = (String)message.getHeaders().get(AmqpHeaders.CORRELATION_ID);
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        log.error("deliveryTag=={}, correlationId : {}", deliveryTag, correlationId);

        channel.basicNack(deliveryTag, false, false);

    }

}
