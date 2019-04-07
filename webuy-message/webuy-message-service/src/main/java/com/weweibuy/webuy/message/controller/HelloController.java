package com.weweibuy.webuy.message.controller;

import com.baidu.fsg.uid.UidGenerator;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description
 * @Author durenhao
 * @Date 2018/10/11 16:44
 **/
@RestController
@Slf4j
public class HelloController {

    @Autowired
    private UidGenerator uidGenerator;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AsyncRabbitTemplate asyncRabbitTemplate;


    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            if(ack){
                log.error("消息已确认, case={}", cause);
                log.error("confirmCallback:{}", correlationData.toString());
            }else {
                log.error("消息未确认, case={}", cause);
                log.error("confirmCallback:{}", correlationData.toString());
            }
        }
    };

    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(org.springframework.amqp.core.Message message, int replyCode, String replyText, String exchange, String routingKey) {
            MessageProperties properties = message.getMessageProperties();
            String id = properties.getCorrelationId();
            log.error("消息无法送达指定队列，message={}", message.toString());

        }
    };

    @RequestMapping("/uid")
    public Long getUid(){
        return uidGenerator.getUID();
    }


    @RequestMapping("/hello")
    public String helloUser(){
        log.error("================【users】==============");
        log.error("【122222222222222222222222】");
        return "hellomessage";
    }

    @RequestMapping("/queue")
    public String helloQueue(){

        rabbitTemplate.setConfirmCallback(confirmCallback);

        rabbitTemplate.setReturnCallback(returnCallback);
        rabbitTemplate.convertAndSend("fanoutExchange", "", "hello.queue1",
                new CorrelationData("111111232"));
        return "1";
    }


    @RequestMapping("/asyncQueue")
    public String helloAsyncQueue(){

        asyncRabbitTemplate.convertSendAndReceive("fanoutExchange", "", "hello.queue1");
        log.error("【ASYNC???】");

//        rabbitTemplate.setConfirmCallback(confirmCallback);
//
//        rabbitTemplate.setReturnCallback(returnCallback);
//
//        rabbitTemplate.convertAndSend("fanoutExchange", "", "hello.queue1",
//                new CorrelationData("111111232"));
        return "1";
    }


    @RequestMapping("/queue2")
    public String helloQueue2(){

        rabbitTemplate.setConfirmCallback(confirmCallback);

        rabbitTemplate.setReturnCallback(returnCallback);

        rabbitTemplate.convertAndSend("topicExchange", "key.123", "hello.top",
                new CorrelationData("111111232"));
        return "1";
    }

    @RequestMapping("/queue3")
    public String helloQueue3(){

        rabbitTemplate.setConfirmCallback(confirmCallback);

        rabbitTemplate.setReturnCallback(returnCallback);


        rabbitTemplate.convertAndSend("directExchange", "key.#", "hello.directExchange",
                new CorrelationData("111111232"));
        return "1";
    }

    @RabbitListener(queues = "hello.queue3")
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception{
        long seqNo = channel.getNextPublishSeqNo();
        MessageHeaders headers = message.getHeaders();
        Object o = headers.get(AmqpHeaders.MESSAGE_COUNT);
        Object payload = message.getPayload();
        Object id = message.getHeaders().getId();
        log.error("【queue3】data={ }", id);
        log.error("【queue3】消息体是：{}", payload.toString());
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        log.error("deliveryTag=={}", deliveryTag);
        channel.basicNack(deliveryTag, false, false);

    }

    @RabbitListener(queues = "hello.queue4")
    @RabbitHandler
    public void onMessage4(Message message, Channel channel) throws Exception{
        Object payload = message.getPayload();
        Object id = message.getHeaders().getId();
        log.error("【queue4】data={ }", id);
        log.error("【queue4】消息体是：{}", payload.toString());
        MessageHeaders headers = message.getHeaders();
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        log.error("deliveryTag=={}", deliveryTag);
        channel.basicNack(deliveryTag, false, false);

    }

    @RabbitListener(queues = "hello.queue5")
    @RabbitHandler
    public void onMessage5(Message message, Channel channel) throws Exception{
        Object payload = message.getPayload();
        Object id = message.getHeaders().getId();
        log.error("【queue5】data={ }", id);
        log.error("【queue5】消息体是：{}", payload.toString());
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        log.error("deliveryTag=={}", deliveryTag);
        channel.basicNack(deliveryTag, false, false);

    }

}
