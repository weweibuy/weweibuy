package com.weweibuy.webuy.support.message.handler;

import com.rabbitmq.client.Channel;
import com.weweibuy.webuy.support.service.SmsCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 对于webuy-user服务的消息监听,并处理消息
 * @ClassName UserListener
 * @Description
 * @Author durenhao
 * @Date 2019/1/19 19:58
 **/
@Slf4j
@Component
public class UserListener {

    @Autowired
    private SmsCodeService smsCodeService;

    @RabbitListener(queues = "user.sms.code")
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            Object payload = message.getPayload();
            String mobile = payload.toString();
            Object id = message.getHeaders().get(AmqpHeaders.CORRELATION_ID);
            log.info("【smscode 收到消息:{}; CORRELATION_ID: {}】", mobile, id);
            smsCodeService.sendSmsCode(mobile);
        }finally {
            // 不确认(Ack)消息将会假死进入 unacked 状态
            // Nack不重回队列,且没有死信队列,消息丢失
            channel.basicAck(((Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG)), false);
        }
    }

}