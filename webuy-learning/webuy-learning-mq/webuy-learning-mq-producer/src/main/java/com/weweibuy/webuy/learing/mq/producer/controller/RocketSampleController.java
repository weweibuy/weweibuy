/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learing.mq.producer.controller;

import com.weweibuy.webuy.learing.mq.producer.sample.RocketSampleProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/12/26 12:19
 **/
@RestController
public class RocketSampleController {

    private final RocketSampleProducer rocketSampleProducer;

    public RocketSampleController(RocketSampleProducer rocketSampleProducer) {
        this.rocketSampleProducer = rocketSampleProducer;
    }

    @GetMapping("/rocket/send")
    public String send(String topic, String msg) {
        rocketSampleProducer.send(topic, msg);
        return "OK!";
    }


}
