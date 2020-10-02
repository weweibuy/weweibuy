package com.weweibuy.webuy.learing.mq.producer.amqp;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.weweibuy.framework.common.core.utils.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

@Slf4j
public class AmqpTest {

    private Channel channel;

    private static final String DIRECT_EXCHANGE_NAME = "test.direct.exchange_01";

    private static final String FANOUT_EXCHANGE_NAME = "test.fanout.exchange_01";

    private static final String FANOUT_QUEUE_NAME = "test.fanout.queue";

    private static final String QUEUE_NAME = "test_queue_01";


    @Before
    public void bf() throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("106.12.95.245");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/test");
        connectionFactory.setUsername("user01");
        connectionFactory.setPassword("ak402507979");
        Connection connection = connectionFactory.newConnection();
        channel = connection.createChannel();
    }

    /**
     * direct需要路由key
     *
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        channel.exchangeDeclare(DIRECT_EXCHANGE_NAME, "direct", true);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        channel.queueBind(QUEUE_NAME, DIRECT_EXCHANGE_NAME, "test.#");
        byte[] messageBodyBytes = "Hello, world!".getBytes();
        channel.basicPublish(DIRECT_EXCHANGE_NAME, "test.#", null, messageBodyBytes);
    }

    /**
     * fanout 没有路由键
     *
     * @throws Exception
     */
    @Test
    public void test02() throws Exception {
        channel.exchangeDeclare(FANOUT_EXCHANGE_NAME, "fanout", true);
        channel.queueDeclare(FANOUT_QUEUE_NAME, true, false, false, null);
        channel.queueBind(FANOUT_QUEUE_NAME, FANOUT_EXCHANGE_NAME, "test.#");
        byte[] messageBodyBytes = "Hello, world!".getBytes();
        Stream.iterate(0 , i -> i+ 1)
                .limit(100)
                .forEach(i -> {
                    try {
                        channel.basicPublish(FANOUT_EXCHANGE_NAME, "test.#", null, messageBodyBytes);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    /**
     * 发送带有属性的消息
     *
     * @throws Exception
     */
    @Test
    public void test03() throws Exception {
        channel.exchangeDeclare(DIRECT_EXCHANGE_NAME, "direct", true);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        channel.queueBind(QUEUE_NAME, DIRECT_EXCHANGE_NAME, "test.#");
        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                .deliveryMode(2)
                .correlationId(IdWorker.nextStringId())
                .contentEncoding("UTF-8")
                .build();
        Stream.iterate(0 , i -> i+ 1)
                .limit(100)
                .forEach(i -> {
                    try {
                        channel.basicPublish(DIRECT_EXCHANGE_NAME, "test.#", properties, "properties message".getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }


}