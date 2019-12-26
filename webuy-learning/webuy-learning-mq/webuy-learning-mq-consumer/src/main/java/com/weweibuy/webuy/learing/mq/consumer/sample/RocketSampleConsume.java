/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learing.mq.consumer.sample;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2019/12/26 14:41
 **/
@Slf4j
@Component
@RocketMQMessageListener(topic = "TEST_SAMPLE_01", consumerGroup = "MY-CONSUMER_TEST_SAMPLE_01")
public class RocketSampleConsume implements RocketMQListener<String> {

    public void onMessage(String message) {
        log.info("received message: {}", message);
    }

}
