package com.weweibuy.webuy.learing.mq.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class MqProducerApplicationTest {

    private static final String NAME_SERVER = "106.12.95.245:9876";

    private static final String TOPIC = "test_producer_topic";

    private String producerGroup = "test_producer_group";

    private DefaultMQProducer producer;

    @Before
    public void bf() throws Exception {
        producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(NAME_SERVER);
        producer.start();
    }

    @Test
    public void test01() throws Exception {
        Message msg = new Message(TOPIC, "test",
                ("Hello RocketMQ 3").getBytes(RemotingHelper.DEFAULT_CHARSET));
        SendResult send = producer.send(msg);
        String msgId = send.getMsgId();
        log.info("messageId: {}", msgId);
        log.info("{}", send);

    }

}