package com.weweibuy.webuy.learing.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

@Slf4j
public class MqConsumerApplicationTest {

    private static final String NAME_SERVER = "106.12.95.245:9876";

    private static final String TOPIC = "test_producer_topic";

    private String producerGroup = "test_producer_group";

    private DefaultMQPushConsumer consumer;

    @Before
    public void bf() throws Exception {
        consumer = new DefaultMQPushConsumer(producerGroup);
        consumer.setNamesrvAddr(NAME_SERVER);
        consumer.subscribe(TOPIC, "*");
    }

    @Test
    public void test01() throws Exception {
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                msgs.stream().forEach(msg -> {
                    log.info("收到消息: {}", new String(msg.getBody()));
                });
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        });
        consumer.start();
        while (true){
            Thread.sleep(500);
        }

    }


}