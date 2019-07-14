package com.weweibuy.webuy.learning.spring.reactor;

import lombok.Getter;
import reactor.core.publisher.BaseSubscriber;

/**
 * @author durenhao
 * @date 2019/5/28 22:41
 **/
@Getter
public class MyEventProcessor extends BaseSubscriber<String> {

    private MyEventListener listener;

    private SingleThreadEventListener singleThreadEventListener;

    public void register(MyEventListener listener) {
        this.listener = listener;
    }

    public void push(String s){
        listener.onDataChunk(s);
    }

    public void register2(SingleThreadEventListener listener) {
        this.singleThreadEventListener = listener;
    }

    public MyEventListener getListener() {
        return listener;
    }
}
