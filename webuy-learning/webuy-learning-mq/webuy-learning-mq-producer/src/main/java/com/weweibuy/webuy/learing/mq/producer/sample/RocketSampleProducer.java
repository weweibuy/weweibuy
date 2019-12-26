/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learing.mq.producer.sample;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/12/26 12:15
 **/
@Component
public class RocketSampleProducer {

    private final RocketMQTemplate rocketMQTemplate;

    public RocketSampleProducer(RocketMQTemplate rocketMQTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
    }


    public void send(String topic, String msg){
        rocketMQTemplate.convertAndSend(topic, msg);
    }

}
