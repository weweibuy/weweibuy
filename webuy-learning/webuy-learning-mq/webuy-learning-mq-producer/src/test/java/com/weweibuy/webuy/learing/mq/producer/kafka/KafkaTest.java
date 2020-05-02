package com.weweibuy.webuy.learing.mq.producer.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author durenhao
 * @date 2020/5/1 20:21
 **/
@Slf4j
public class KafkaTest {

    private static final String TOPIC = "KAFKA_TEST";

    private KafkaProducer<String, String> kafkaProducer;

    @Before
    public void bf() {
        Properties p = new Properties();
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");//kafka地址，多个地址用逗号分割
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        kafkaProducer = new KafkaProducer<>(p);
    }


    @Test
    public void test01() throws InterruptedException, TimeoutException, ExecutionException {
        try {
            String msg = "Hello," + new Random().nextInt(100);
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC, msg);
            Future<RecordMetadata> metadataFuture = kafkaProducer.send(record);
            RecordMetadata recordMetadata = metadataFuture.get(1, TimeUnit.SECONDS);
            System.out.println("消息发送成功:" + msg);
            Thread.sleep(500);
        } finally {
            kafkaProducer.close();
        }

    }

    @Test
    public void test02() throws InterruptedException, TimeoutException, ExecutionException {
        try {
            String msg = "Hello," + new Random().nextInt(100);
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC, msg);
            Future<RecordMetadata> metadataFuture = kafkaProducer.send(record, (m, e) -> {
                log.info("发送完成: 元数据: {} 异常: {}", m, e);
            });
            RecordMetadata recordMetadata = metadataFuture.get(1, TimeUnit.SECONDS);
            System.out.println("消息发送成功:" + msg);
        } finally {
            kafkaProducer.close();
        }

    }


}
