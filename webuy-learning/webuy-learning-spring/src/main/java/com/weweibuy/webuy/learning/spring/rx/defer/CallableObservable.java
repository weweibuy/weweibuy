package com.weweibuy.webuy.learning.spring.rx.defer;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @ClassName CallableObservable
 * @Description
 * @Author durenhao
 * @Date 2019/3/27 22:43
 **/
@Slf4j
public class CallableObservable implements Callable<ObservableSource<String>> {

    @Override
    public ObservableSource<String> call() throws Exception {
        log.error("创建定义关系");
        // 返回事件源  事件源是 callable 类型
        return Observable.create(new RxDefObservable());
    }
}
