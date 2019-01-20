package com.weweibuy.message.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * RabbitMQ 队列交换机信息配置
 * @ClassName RabbitMQ_Config
 * @Description
 * @Author durenhao
 * @Date 2018/10/14 10:39
 **/
@Configuration
//@PropertySource("classpath:rabbitmq/rabbitmq.properties")  用于读取指定配置文件
//@ConfigurationProperties(prefix = "rabbitmq")
@Slf4j
public class RabbitmqConfig {


    /** 死信队列交换机属性名 */
    private static final String X_DEAD_LETTER_EXCHANGE = "x-dead-letter-exchange";

    /** 死信队列路由键属性名 */
    private static final String X_DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

    /** 过期时间属性名 */
    private static final String X_MESSAGE_TTL = "x-message-ttl";

    /** 过期时间 单位:ms */
    private static final int TTL = 10000;


    @Bean
    @Autowired
    public AsyncRabbitTemplate asyncRabbitTemplate(RabbitTemplate rabbitTemplate){
        return new AsyncRabbitTemplate(rabbitTemplate);
    }

    @Bean
    public Queue dlxQueue() {
        return new Queue("dlx.queue", true);
    }

    @Bean
    public Queue queue1() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(X_DEAD_LETTER_EXCHANGE, "dlx.exchange");
        map.put(X_DEAD_LETTER_ROUTING_KEY, "dlx.queue");
        map.put(X_MESSAGE_TTL, TTL);
        return new Queue("hello.queue1", true, false, false, map); // true表示持久化该队列
    }



    @Bean
    public Queue queue2() {
        return new Queue("hello.queue2", true);
    }

    @Bean
    public Queue queue22() {
        return new Queue("hello.queue22", true);
    }

    @Bean
    public Queue queue3() {
        return new Queue("hello.queue3", true);
    }


    @Bean
    public Queue queue4() {
        return new Queue("hello.queue4", true);
    }

    @Bean
    public Queue queue5() {
        return new Queue("hello.queue5", true);
    }

    @Bean
    public Queue queue6() {
        return new Queue("hello.queue6", true);
    }

    @Bean
    public Queue queue7() {
        return new Queue("hello.queue7", true);
    }

    @Bean
    public Queue queue8() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(X_DEAD_LETTER_EXCHANGE, "dlx.exchange");
        map.put(X_DEAD_LETTER_ROUTING_KEY, "dlx.queue");
        map.put(X_MESSAGE_TTL, TTL);
        return new Queue("hello.queue8", true, false, false, map); // true表示持久化该队列
    }

    //声明交互器
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange", true, false);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange", true, false);
    }

    //声明交互器
    @Bean
    TopicExchange dlxTopicExchange() {
        return new TopicExchange("dlx.exchange");
    }

    @Bean
    public Binding binding8() {
        return BindingBuilder.bind(dlxQueue()).to(dlxTopicExchange()).with("dlx.#");
    }

    //绑定
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(fanoutExchange());
    }

    //绑定
    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(queue3()).to(fanoutExchange());
    }


    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("key.#");
    }

    @Bean
    public Binding binding22() {
        return BindingBuilder.bind(queue22()).to(topicExchange()).with("key.#");
    }

    @Bean
    public Binding binding4() {
        return BindingBuilder.bind(queue4()).to(topicExchange()).with("key.#");
    }

    @Bean
    public Binding binding5() {
        return BindingBuilder.bind(queue5()).to(directExchange()).with("key.#");
    }

    @Bean
    public Binding binding6() {
        return BindingBuilder.bind(queue6()).to(directExchange()).with("key.#");
    }

    @Bean
    public Binding binding7() {
        BindingBuilder.bind(queue8()).to(directExchange()).with("key.#");
        return BindingBuilder.bind(queue7()).to(directExchange()).with("key.#");
    }

    @Bean
    public Binding binding9() {
        return BindingBuilder.bind(queue8()).to(directExchange()).with("key.#");
    }



}
