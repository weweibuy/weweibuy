package com.weweibuy.webuy.learning.spring.reactor;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @author durenhao
 * @date 2019/5/28 23:14
 **/
@Data
public class MessageProcessor {

    private MyMessageListener listener;

    public void register(MyMessageListener listener){
        this.listener = listener;
    }

    public List<String> request(Long n){
        return Collections.singletonList(n + "");
    }
}
