package com.weweibuy.webuy.learning.spring.rx.concat;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName RxConcatObservableFirst
 * @Description
 * @Author durenhao
 * @Date 2019/3/24 23:24
 **/
@Slf4j
public class RxConcatObservableFirst implements ObservableOnSubscribe<String> {

    @Override
    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
        String s = "hello...";
        log.debug("subject first 发射 {}", s);
        emitter.onNext(s);
        log.debug("subject first complete");
        // 在Concat 情况下只有First Complete Second 才会执行
        emitter.onComplete();
    }
}
