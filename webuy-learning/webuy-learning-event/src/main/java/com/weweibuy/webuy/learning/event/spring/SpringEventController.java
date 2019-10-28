package com.weweibuy.webuy.learning.event.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/9/22 11:53
 **/
@RestController
@RequestMapping("/event")
public class SpringEventController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/jit")
    public Object jitEvent(){
        return "success";
    }

    @RequestMapping("/bbc")
    public Object bbcEvent(){
        return "success";
    }

    @RequestMapping("/bbc2")
    public Object bbcEvent2(){
        return "success";
    }



}
