package com.weweibuy.webuy.order.controller;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ClassName HelloController
 * @Description
 * @Author durenhao
 * @Date 2018/10/14 19:37
 **/
@RestController
@Slf4j
public class HelloWorldController {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }



    /**
     *
     * @param message  注意使用 springframework.messaging.Message，的 message
     * @param channel
     * @throws Exception
     */
    @RabbitListener(queues = "hello.queue1")
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception{
        log.error("【-----------线程为------------】,{}",Thread.currentThread().getName());
        Object payload = message.getPayload();
        Object id = message.getHeaders().getId();
        log.error("【queue1】data={}", id);
        log.error("【queue1 】消息体是：{}", payload.toString());
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        log.error("deliveryTag=={}", deliveryTag);
        channel.basicNack(deliveryTag, false, false);

    }

    @RabbitListener(queues = "hello.queue3")
    @RabbitHandler
    public void onMessage33(Message message, Channel channel) throws Exception{
        log.error("【-----------线程为------------】,{}",Thread.currentThread().getName());
        Object payload = message.getPayload();
        Object id = message.getHeaders().getId();
        log.error("【queue3】data={}", id);
        log.error("【queue3】消息体是：{}", payload.toString());
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        log.error("deliveryTag=={}", deliveryTag);
        channel.basicNack(deliveryTag, false, false);

    }


    /**
     *
     * @param message  注意使用 springframework.messaging.Message，的 message
     * @param channel
     * @throws Exception
     */
    @RabbitListener(queues = "hello.queue2")
    @RabbitHandler
    public void onMessage2(Message message, Channel channel) throws Exception{
        Object payload = message.getPayload();
        Object id = message.getHeaders().getId();
        log.error("【queue2】data={}  ", id);
        log.error("【queue2】消息体是：{}", payload.toString());
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        log.error("deliveryTag=={}", deliveryTag);
        channel.basicNack(deliveryTag, false, false);
    }

    @RabbitListener(queues = "hello.queue22")
    @RabbitHandler
    public void onMessage22(Message message, Channel channel) throws Exception{
        Object payload = message.getPayload();
        Object id = message.getHeaders().getId();
        log.error("【queue22】data={}  ", id);
        log.error("【queue22】消息体是：{}", payload.toString());
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.CORRELATION_ID);
        log.error("deliveryTag=={}", deliveryTag);
        channel.basicNack(deliveryTag, false, false);
    }

    @RabbitListener(queues = "hello.queue6")
    @RabbitHandler
    public void onMessage6(Message message, Channel channel) throws Exception{
        Object payload = message.getPayload();
        Object id = message.getHeaders().getId();
        log.error("【queue6】data={}  ", id);
        log.error("【queue6】消息体是：{}", payload.toString());
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        log.error("deliveryTag=={}", deliveryTag);
        channel.basicNack(deliveryTag, false, false);

    }

    @RabbitListener(queues = "hello.queue4")
    @RabbitHandler
    public void onMessage4(Message message, Channel channel) throws Exception{
        Object payload = message.getPayload();
        Object id = message.getHeaders().getId();
        log.error("【queue4 】data={ }", id);
        log.error("【queue4】消息体是：{}", payload.toString());
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        log.error("deliveryTag=={}", deliveryTag);
        channel.basicNack(deliveryTag, false, false);

    }

    @RabbitListener(queues = "dlx.queue")
    @RabbitHandler
    public void deadMessage(Message message, Channel channel) throws Exception{
        MessageHeaders headers = message.getHeaders();
        Object replyChannel = headers.getReplyChannel();
        Object o = headers.get(AmqpHeaders.APP_ID);
        Object o1 = headers.get(AmqpHeaders.REDELIVERED);
        ArrayList<HashMap> list = (ArrayList<HashMap>)headers.get("x-death");
        Long o2 = (Long)list.get(0).get("count");
//        if(o2 < 2){
//            rabbitTemplate.convertAndSend("fanoutExchange", "", "hello.queue1",
//                    new CorrelationData("111111232"));
//        }
        log.error("【-----------线程为------------】,{}",Thread.currentThread().getName());
        Object payload = message.getPayload();
        Object id = message.getHeaders().getId();
        log.error("【死信】data={ }", id);
        log.error("【死信】消息体是：{}", payload.toString());
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        log.error("【死信】deliveryTag=={}", deliveryTag);
        channel.basicNack(deliveryTag, false, false);

    }

}
