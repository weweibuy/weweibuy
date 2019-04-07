package com.weweibuy.webuy.learning.spring.rx.map;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName RxMapObservable
 * @Description
 * @Author durenhao
 * @Date 2019/3/24 23:00
 **/
@Slf4j
public class RxMapObservable implements ObservableOnSubscribe<Integer> {

    @Override
    public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
        Integer input = 123456;
        log.info("subject 生产一个 integer 的数字：{} ", input);
        emitter.onNext(input);
    }
}
