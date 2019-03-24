package com.weweibuy.test.rx.concat;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName RxConcatObserver
 * @Description
 * @Author durenhao
 * @Date 2019/3/24 23:35
 **/
@Slf4j
public class RxConcatObserver implements Observer<String> {
    @Override
    public void onSubscribe(Disposable d) {
        log.error("监听者 建立关系");
    }

    @Override
    public void onNext(String s) {
        log.error("监听者 监听到消息 {}", s);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {
        log.error("监听者 监听到 Complete 事件 ");
    }
}
