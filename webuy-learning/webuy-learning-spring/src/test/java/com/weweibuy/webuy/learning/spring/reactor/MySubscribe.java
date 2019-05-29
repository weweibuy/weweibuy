package com.weweibuy.webuy.learning.spring.reactor;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

/**
 * @author durenhao
 * @date 2019/5/29 21:42
 **/
@Slf4j
public class MySubscribe extends BaseSubscriber<Integer> {

    protected void hookOnSubscribe(Subscription subscription){
        subscription.request(Long.MAX_VALUE);
    }

    protected void hookOnNext(Integer value){
        log.info("收到消息 : {}", value);
    }

    protected void hookOnComplete() {
        log.info("完成了 ....");
    }

    protected void hookOnError(Throwable throwable) {
        log.error("发生错误: {}", throwable.getMessage());
    }


}
