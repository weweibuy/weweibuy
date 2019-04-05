package com.weweibuy.webuy.backstage.test.rx.concat;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName RxConcatObservableSecond
 * @Description
 * @Author durenhao
 * @Date 2019/3/24 23:26
 **/
@Slf4j
public class RxConcatObservableSecond implements ObservableOnSubscribe<String> {

    @Override
    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
        String s = " world....";
        log.debug("subject Second 发射 {}", s);
        emitter.onNext(s);
    }
}
