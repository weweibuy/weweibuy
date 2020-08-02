package com.weweibuy.webuy.learing.mq.consumer.config;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.amqp.core.Message;

/**
 * @author durenhao
 * @date 2020/8/2 16:02
 **/
@Slf4j
public class RabbitConsumerMethodAdvice implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] arguments = invocation.getArguments();
        Channel channel = (Channel) arguments[0];
        Message message = (Message) arguments[1];
        log.info("RabbitMq 消费消息: {}, 属性: {}", new String(message.getBody()), message.getMessageProperties());
        try {
            return invocation.proceed();
        } finally {
            log.info("RabbitMq 消费消息结果: {}");
        }
    }
}
