package com.weweibuy.webuy.learing.mq.consumer.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * @author durenhao
 * @date 2020/5/1 20:31
 **/
public class KafkaConsumerTest {

    private static final String TOPIC = "KAFKA_TEST";

    KafkaConsumer<String, String> kafkaConsumer;

    @Before
    public void bf() {
        Properties p = new Properties();
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.GROUP_ID_CONFIG, "KAFKA_TEST_CG");
        p.put(ConsumerConfig.INTERCEPTOR_CLASSES_CONFIG, LogProducerInterceptorTest.class.getName());

        kafkaConsumer = new KafkaConsumer<String, String>(p);
        // 可以订阅多个
        kafkaConsumer.subscribe(Collections.singletonList(TOPIC));// 订阅消息
        // 指定订阅分区
//        kafkaConsumer.assign(Collections.singleton(new TopicPartition(TOPIC, 0)));

        Set<TopicPartition> assignment = kafkaConsumer.assignment();
        // 指定位置消费
        assignment.forEach(t -> kafkaConsumer.seek(t, 0));

    }


    @Test
    public void test01() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(10));
        for (ConsumerRecord<String, String> record : records) {
            System.err.println(String.format("topic:%s,offset:%d,消息:%s", //
                    record.topic(), record.offset(), record.value()));
        }
        countDownLatch.await();
    }


}
