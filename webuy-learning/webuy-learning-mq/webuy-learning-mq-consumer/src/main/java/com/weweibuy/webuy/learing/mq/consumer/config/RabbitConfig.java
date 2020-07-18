package com.weweibuy.webuy.learing.mq.consumer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/12/26 21:49
 **/
@Configuration
public class RabbitConfig {

    @Autowired(required = false)
    private List<MessagePostProcessor> messagePostProcessorList;

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean(name = "rabbitListenerContainerFactory")
    @ConditionalOnProperty(prefix = "spring.rabbitmq.listener", name = "type", havingValue = "simple", matchIfMissing = true)
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer,
            ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        if(CollectionUtils.isNotEmpty(messagePostProcessorList)){
            MessagePostProcessor[] arr = new MessagePostProcessor[messagePostProcessorList.size()];
            messagePostProcessorList.toArray(arr);
            factory.setAfterReceivePostProcessors(arr);
        }
        configurer.configure(factory, connectionFactory);
        return factory;
    }

}
