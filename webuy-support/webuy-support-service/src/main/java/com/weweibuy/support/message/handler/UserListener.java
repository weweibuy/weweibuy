package com.weweibuy.support.message.handler;

import com.rabbitmq.client.Channel;
import com.weweibuy.support.service.SmsCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
        Object payload = message.getPayload();
        String mobile = payload.toString();
        smsCodeService.sendSmsCode(mobile);
    }

}