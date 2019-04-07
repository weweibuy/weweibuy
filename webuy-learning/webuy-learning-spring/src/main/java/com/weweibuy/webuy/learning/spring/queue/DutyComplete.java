package com.weweibuy.webuy.learning.spring.queue;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @ClassName DutyComplete
 * @Description
 * @Author durenhao
 * @Date 2019/3/17 21:07
 **/
@Data
public class DutyComplete extends ApplicationEvent {

    private Long id;

    private String name;

    private String sessionKey;

    public DutyComplete(Object source){
        super(source);
    }

    public DutyComplete(Object source, Long id, String name, String sessionKey) {
        super(source);
        this.id = id;
        this.name = name;
        this.sessionKey = sessionKey;
    }
}
