package com.weweibuy.webuy.backstage.test.rx.map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName RxMapObserver
 * @Description
 * @Author durenhao
 * @Date 2019/3/24 23:03
 **/
@Slf4j
public class RxMapObserver implements Observer<String> {

    @Override
    public void onSubscribe(Disposable d) {
        log.error("监听 建立关系");
    }

    @Override
    public void onNext(String s) {
        log.error("监听 收到 String类型数据 ：{}", s);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
