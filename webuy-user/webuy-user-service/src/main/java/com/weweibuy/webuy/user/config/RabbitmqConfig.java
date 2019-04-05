package com.weweibuy.webuy.user.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ 队列交换机信息配置
 * @ClassName RabbitmqConfig
 * @Description
 * @Author durenhao
 * @Date 2018/10/14 10:39
 **/
@Configuration
@Slf4j
public class RabbitmqConfig {


    /** 死信队列交换机属性名 */
    private static final String X_DEAD_LETTER_EXCHANGE = "x-dead-letter-exchange";

    /** 死信队列路由键属性名 */
    private static final String X_DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

    /** 过期时间属性名 */
    private static final String X_MESSAGE_TTL = "x-message-ttl";

    /** 过期时间 单位:ms */
    private static final int TTL = 10000;

    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            log.error("消息未确认, case={}", cause);
            log.error("confirmCallback:{}", correlationData.toString());
        }

        ;
    };

    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(org.springframework.amqp.core.Message message, int replyCode, String replyText, String exchange, String routingKey) {
            MessageProperties properties = message.getMessageProperties();
            String id = properties.getCorrelationId();
            log.error("消息无法送达指定队列，message={}", message.toString());
        }
    };


    @Bean
    @Autowired
    public AsyncRabbitTemplate asyncRabbitTemplate(RabbitTemplate rabbitTemplate){
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        return  new AsyncRabbitTemplate(rabbitTemplate);
    }

    @Bean
    public FanoutExchange smsCodeFanoutExchange(){
        return new FanoutExchange("user_sms_code", true, false);
    }

    @Bean
    public Queue smsCodeQueue() {
        return new Queue("user.sms.code", true);
    }

    //绑定
    @Bean
    public Binding bindingSmsCodeQueue() {
        return BindingBuilder.bind(smsCodeQueue()).to(smsCodeFanoutExchange());
    }


}
