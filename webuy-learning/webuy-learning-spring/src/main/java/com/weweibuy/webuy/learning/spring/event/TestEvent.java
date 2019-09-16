package com.weweibuy.webuy.learning.spring.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @author durenhao
 * @date 2019/9/16 23:10
 **/
@Data
public class TestEvent extends ApplicationEvent {

    private String msg;

    public TestEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
}
