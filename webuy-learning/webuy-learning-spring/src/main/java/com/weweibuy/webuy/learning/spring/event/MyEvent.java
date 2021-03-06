package com.weweibuy.webuy.learning.spring.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @ClassName MyEvent
 * @Description
 * @Author durenhao
 * @Date 2019/3/16 21:04
 **/
@Data
public class MyEvent extends ApplicationEvent {

    private String name = "zhangsan";

    private String msg;

    public MyEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
}
