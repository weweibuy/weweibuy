package com.weweibuy.webuy.learning.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MyEventController
 * @Description
 * @Author durenhao
 * @Date 2019/3/16 21:11
 **/
@RestController
public class MyEventController {

    @Autowired
    private MyEventService eventService;

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/event/push")
    public String pushEvent(){
        eventService.pushEvent();
        applicationContext.publishEvent(new TestEvent(this, "test event"));
        return "success";
    }

    @GetMapping("/event/push2")
    public String pushEvent2(){
        applicationContext.publishEvent(new TestEvent(this, "test event"));
        return "success";
    }


}
