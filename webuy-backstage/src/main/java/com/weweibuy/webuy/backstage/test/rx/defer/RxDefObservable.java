package com.weweibuy.webuy.backstage.test.rx.defer;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName RxDefObservable
 * @Description
 * @Author durenhao
 * @Date 2019/3/27 22:48
 **/
@Slf4j
public class RxDefObservable implements ObservableOnSubscribe<String> {

    @Override
    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
        String s = "hello ..  def .. callable";
        log.error("被观察者 发射值 {}", s);
        emitter.onNext(s);
        emitter.onComplete();
    }
}
