package com.weweibuy.test.event;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/event/push")
    public String pushEvent(){
        eventService.pushEvent();
        return "success";
    }


}
