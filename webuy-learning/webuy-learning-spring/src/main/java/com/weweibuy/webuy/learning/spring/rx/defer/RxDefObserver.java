package com.weweibuy.webuy.learning.spring.rx.defer;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName RxDefObserver
 * @Description
 * @Author durenhao
 * @Date 2019/3/27 22:51
 **/
@Slf4j
public class RxDefObserver implements Observer<String> {


    @Override
    public void onSubscribe(Disposable d) {
        log.info("def  建立 关系");
    }

    @Override
    public void onNext(String s) {
        log.info("def 监听收到消息 {}", s);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {
        log.info("def 监听 完成");
    }
}
