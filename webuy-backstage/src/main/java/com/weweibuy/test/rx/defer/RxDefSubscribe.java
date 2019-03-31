package com.weweibuy.test.rx.defer;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Future;

/**
 * @ClassName RxDefSubscribe
 * @Description
 * @Author durenhao
 * @Date 2019/3/27 22:53
 **/
@Slf4j
public class RxDefSubscribe {

    public Future<String> subscribe(){

        Observable<String> observable = Observable.defer(new CallableObservable());
//        observable.subscribe(new RxDefObserver());
        Future<String> future = observable.toFuture();
        return future;
    }


}
