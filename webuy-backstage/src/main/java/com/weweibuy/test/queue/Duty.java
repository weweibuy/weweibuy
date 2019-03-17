package com.weweibuy.test.queue;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @ClassName Duty
 * @Description
 * @Author durenhao
 * @Date 2019/3/17 9:43
 **/
@Data
@ToString
@EqualsAndHashCode
public class Duty extends ApplicationEvent {

    private Long id;

    private String name;

    private String sessionKey;

    public Duty(Object source){
        super(source);
    }

    public Duty(Object source, Long id, String name, String sessionKey) {
        super(source);
        this.id = id;
        this.name = name;
        this.sessionKey = sessionKey;
    }


}
