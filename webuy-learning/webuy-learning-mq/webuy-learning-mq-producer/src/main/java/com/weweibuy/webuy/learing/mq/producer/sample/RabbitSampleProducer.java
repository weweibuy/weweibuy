/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learing.mq.producer.sample;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/12/26 16:07
 **/
@Component
public class RabbitSampleProducer {

    private final RabbitTemplate rabbitTemplate;

    public RabbitSampleProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void send(String exchange, String routingKey, String msg) {
        CommonJsonResponse success = CommonJsonResponse.success(msg);
        rabbitTemplate.convertAndSend(exchange, routingKey, success);
    }
}
