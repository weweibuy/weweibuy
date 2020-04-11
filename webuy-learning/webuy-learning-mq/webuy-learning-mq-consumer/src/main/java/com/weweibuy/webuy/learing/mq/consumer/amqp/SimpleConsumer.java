package com.weweibuy.webuy.learing.mq.consumer.amqp;

import com.rabbitmq.client.Channel;
import com.weweibuy.webuy.common.model.dto.CommonDataJsonResponse;
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
    public void onMessage(@Payload CommonDataJsonResponse<String> msg, @Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag, Channel channel) throws Exception {
        log.info("msg 是: {}", msg.getData());
        /**
         * 若消息已经被消费，但是后续代码抛出异常，使用spring进行管理的话，消费端业务路基被回滚，也会造成实际消息的丢失
         * 手动调用以下防方法进行确认，手动确认可以在业务失败进行一些操作,以下为不同确认策略。
         * ack   消息接收到并且被成功消费
         * nack  消息接收到，但是消费失败，可设置重新入队列等待别的消费者消费，也可以选择直接丢弃
         * reject 消息被拒绝
         *
         */
        channel.basicAck(deliveryTag, false);
//        channel.basicNack(deliveryTag, false, true);
        channel.basicReject(deliveryTag, true);
    }


}
