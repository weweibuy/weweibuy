package com.weweibuy.test.rx;

import com.weweibuy.thead.ThreadPoolHolder;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName RxSubscribe
 * @Description
 * @Author durenhao
 * @Date 2019/3/24 20:23
 **/
public class RxSubscribe {

    public void subscribe(){
        Observable<String> observable = Observable.create(new RxObservable());
        observable.subscribe(new RxObserver());

    }

    /**
     * 异步发射与接收
     */
    public void asyncSubscribe(){
        Observable.create(new RxObservable())
                .subscribeOn(Schedulers.from(ThreadPoolHolder.getCachedPoll()))
                .observeOn(Schedulers.from(ThreadPoolHolder.getFixPoll()))
                .subscribe(new RxObserver());
    }
}
