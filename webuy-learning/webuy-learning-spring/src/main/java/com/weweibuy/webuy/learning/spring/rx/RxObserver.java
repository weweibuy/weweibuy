package com.weweibuy.webuy.learning.spring.rx;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName RxObserver
 * @Description
 * @Author durenhao
 * @Date 2019/3/24 20:12
 **/
@Slf4j
public class RxObserver implements Observer<String> {

    private int count;

    // 用于解除订阅关系
    private Disposable mDisposable;

    @Override
    public void onSubscribe(Disposable d) {
        this.mDisposable = d;
        log.error("观察者建立 订阅关系 {}", d.isDisposed());
    }

    @Override
    public void onNext(String s) {
        count ++;
        if(count > 10){
            mDisposable.dispose();
            log.error("监听者值监听{} 消息 多了我就取消监听关系", count);
        }
        log.error("监听到内容：{}", s);
    }

    @Override
    public void onError(Throwable e) {
        log.error("监听到 异常 ： {},", e.getMessage());
    }

    @Override
    public void onComplete() {
        log.error("监听到 完成事件 。。。。");
    }
}
