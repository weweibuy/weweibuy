package com.weweibuy.webuy.learing.mq.consumer.rocket;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.message.MessageExt;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

@Slf4j
public class RocketMqTest {

    private static final String NAME_SERVER = "122.51.171.126:9876";

    private static final String TOPIC = "TEST_SAMPLE_01";

    private String producerGroup1 = "test_producer_group1";

    private String producerGroup2 = "test_producer_group2";


    private DefaultMQPushConsumer consumerG1;

    private DefaultMQPushConsumer consumerG2;


    @Before
    public void bf() throws Exception {
        consumerG1 = new DefaultMQPushConsumer(producerGroup1);
        consumerG1.setNamesrvAddr(NAME_SERVER);
        consumerG1.subscribe(TOPIC, "*");

        consumerG2 = new DefaultMQPushConsumer(producerGroup2);
        consumerG2.setNamesrvAddr(NAME_SERVER);
        consumerG2.subscribe(TOPIC, "test");

    }

    /**
     * 一个group
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        consumerG1.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                msgs.stream().forEach(msg -> {
                    log.info("消费组1 Listener1 收到消息: {}", new String(msg.getBody()));
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumerG1.start();

        consumerG1.setConsumeThreadMax(1);
        int max = consumerG1.getConsumeThreadMax();
        int mix = consumerG1.getConsumeThreadMin();


        System.err.println(max);
        System.err.println(mix);




        consumerG2.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                msgs.stream().forEach(msg -> {
                    int ackIndex = context.getAckIndex();
                    log.info("ackIndex : {}", ackIndex);
                    log.info("消费组2 收到消息: {}, 数量: {}; messageId: {}, 队列id: {}", new String(msg.getBody()), msgs.size(),
                            msg.getMsgId(), msg.getQueueId());
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumerG2.start();
        while (true) {
            Thread.sleep(500);
        }
    }


    @Test
    public void test02() throws Exception {
        consumerG1.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                msgs.stream().forEach(msg -> {
                    boolean autoCommit = context.isAutoCommit();
                    log.info("消费组1 收到消息: {}, messageId: {}, 队列id: {}", new String(msg.getBody()),
                            msg.getMsgId(), msg.getQueueId());
                });
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumerG1.start();
        while (true) {
            Thread.sleep(500);
        }
    }

    @Test
    public void test03() throws Exception {
        consumerG2.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                MessageExt messageExt = msgs.get(0);
                Map<String, String> properties = messageExt.getProperties();
                try {
                    msgs.stream().forEach(msg -> {
                        log.info("消费组1 Listener1 收到消息: {}; id: {}", new String(msg.getBody()), msg.getMsgId());
                        throw new RuntimeException();
                    });
                } catch (Exception e) {
                    String origin_message_id = properties.get("ORIGIN_MESSAGE_ID");
                    int reconsumeTimes = messageExt.getReconsumeTimes();
                    log.info("消息属性: {}", properties);
                    log.info("原始msgId: {}", origin_message_id);
                    log.info("重试次数: {}", reconsumeTimes);
                    if(reconsumeTimes >= 3){
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumerG2.start();
        while (true) {
            Thread.sleep(500);
        }
    }

}