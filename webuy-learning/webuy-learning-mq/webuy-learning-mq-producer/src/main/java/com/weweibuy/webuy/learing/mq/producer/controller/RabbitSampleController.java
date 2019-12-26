/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learing.mq.producer.controller;

import com.weweibuy.webuy.learing.mq.producer.sample.RabbitSampleProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author durenhao
 * @date 2019/12/26 16:27
 **/
@Slf4j
@RestController
public class RabbitSampleController {

    public final RabbitSampleProducer rabbitSampleProducer;

    public RabbitSampleController(RabbitSampleProducer rabbitSampleProducer) {
        this.rabbitSampleProducer = rabbitSampleProducer;
    }

    @GetMapping("/rabbit/send")
    public String send(String exchange, String routingKey, String msg, @RequestHeader Map<String, String> headers) {
        headers.forEach((k, v) -> {
            log.info("key: {}  value: {}", k, v);
        });
        rabbitSampleProducer.send(exchange, routingKey, msg);
        return "OK!";
    }
}
