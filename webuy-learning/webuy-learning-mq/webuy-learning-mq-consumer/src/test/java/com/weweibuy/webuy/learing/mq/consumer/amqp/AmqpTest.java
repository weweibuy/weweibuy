package com.weweibuy.webuy.learing.mq.consumer.amqp;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

@Slf4j
public class AmqpTest {

    private Channel channel;

    private static final String DIRECT_EXCHANGE_NAME = "test.direct.exchange_01";

    private static final String FANOUT_EXCHANGE_NAME = "test.fanout.exchange_01";

    private static final String FANOUT_QUEUE_NAME = "test.fanout.queue";

    private static final String QUEUE_NAME = "test_queue_01";

    private static final String IP = "106.12.95.245";

    @Before
    public void bf() throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(IP);
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/test");
        connectionFactory.setUsername("user01");
        connectionFactory.setPassword("ak402507979");
        Connection connection = connectionFactory.newConnection();
        channel = connection.createChannel();
    }

    @Test
    public void test01() throws Exception {
        channel.basicConsume(QUEUE_NAME, false, new Consumer() {
            @Override
            public void handleConsumeOk(String consumerTag) {
                log.info("handleConsumeOk -->  consumerTag : {}", consumerTag);
            }

            @Override
            public void handleCancelOk(String consumerTag) {
                log.info("handleCancelOk -->  consumerTag : {}", consumerTag);
            }

            @Override
            public void handleCancel(String consumerTag) throws IOException {
                log.info("handleCancel -->  consumerTag : {}", consumerTag);
            }

            @Override
            public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
                log.info("handleShutdownSignal -->  consumerTag : {}", consumerTag);
            }

            @Override
            public void handleRecoverOk(String consumerTag) {

            }

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                long deliveryTag = envelope.getDeliveryTag();
                log.info("收到消息: {}, consumerTag: {}, deliveryTag :{}", new String(body), consumerTag, deliveryTag);
                log.info("envelope: {}", envelope);
                log.info("properties: {}", properties);
                channel.basicNack(deliveryTag, false, false);
            }
        });
        while (true) {
            Thread.sleep(500);
        }
    }


}