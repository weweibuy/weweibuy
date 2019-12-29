package com.weweibuy.webuy.learing.mq.producer.rocket;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class RocketMqTest {

    private static final String NAME_SERVER = "122.51.171.126:9876";

    private static final String TOPIC = "test_producer_topic";

    private String producerGroup = "test_producer_group";

    private DefaultMQProducer producer;

    @Before
    public void bf() throws Exception {
        producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(NAME_SERVER);
        producer.setProducerGroup("12");
        producer.start();
        int clientCallbackExecutorThreads = producer.getClientCallbackExecutorThreads();
        System.err.println(clientCallbackExecutorThreads);
    }

    @Test
    public void test01() throws Exception {
        Stream.iterate(0, n -> n + 1)
                .limit(1)
                .forEach(i -> {
                    Message msg = null;
                    try {
                        if (i % 2 == 0) {
                            msg = new Message(TOPIC, "test",
                                    ("Hello RocketMQ for test " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                        } else {
                            msg = new Message(TOPIC, "dev",
                                    ("Hello RocketMQ for dev " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                        }

//                        msg.setBuyerId();
//                        msg.setTags();
//                        msg.setKeys();
//                        msg.setFlag();
//                        msg.setWaitStoreMsgOK();
//                        producer.send();
                        SendResult send = producer.send(msg, 1);
                        String msgId = send.getMsgId();
                        int queueId = send.getMessageQueue().getQueueId();
                        log.info("发送消息 messageId: {} 成功; 队列: {}", msgId, queueId);
                        log.info("{}", send);
                    } catch (Exception e) {
                    }

                });

    }


    /**
     * 向指定队列发送
     *
     * @throws Exception
     */
    @Test
    public void test02() throws Exception {
        Stream.iterate(0, n -> n + 1)
                .limit(1000)
                .forEach(i -> {
                    Message msg = null;
                    try {
                        msg = new Message(TOPIC, "test",
                                ("Hello RocketMQ  queue" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                        SendResult send = producer.send(msg, new MessageQueueSelector() {
                            @Override
                            public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                                return mqs.get((Integer) arg);
                            }
                        }, 0);// 0 --> 队列下表
                        String msgId = send.getMsgId();
                        int queueId = send.getMessageQueue().getQueueId();
                        log.info("发送消息 messageId: {} 成功; 队列: {}", msgId, queueId);
                        log.info("{}", send);
                    } catch (Exception e) {
                    }
                });

    }

}