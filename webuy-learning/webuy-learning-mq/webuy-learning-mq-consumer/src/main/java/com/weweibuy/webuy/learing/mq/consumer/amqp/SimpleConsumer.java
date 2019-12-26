package com.weweibuy.webuy.learing.mq.consumer.amqp;

import com.rabbitmq.client.Channel;
import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/9/2 22:41
 **/
@Slf4j
@Component
public class SimpleConsumer {


    @RabbitListener(queues = "test_queue_01")
    @RabbitHandler
    public void onMessage(@Payload CommonJsonResponse<String> msg, @Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag, Channel channel) throws Exception {
        log.info("msg 是: {}", msg.getData());
        channel.basicAck(deliveryTag, false);
    }


}
