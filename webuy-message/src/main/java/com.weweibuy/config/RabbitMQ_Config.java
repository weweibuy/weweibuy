package com.weweibuy.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
public class RabbitMQ_Config {

    @Bean
    public Queue queue1() {
        return new Queue("hello.queue1", true); // true表示持久化该队列
    }

    @Bean
    public Queue queue2() {
        return new Queue("hello.queue2", true);
    }

    //声明交互器
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    //绑定
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(fanoutExchange());
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("key.#");
    }



}
