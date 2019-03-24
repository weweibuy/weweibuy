package com.weweibuy.test.rx.concat;

import com.weweibuy.thead.ThreadPoolHolder;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

/**
 * cancat 连接
 * @ClassName RxConcatSubscribe
 * @Description
 * @Author durenhao
 * @Date 2019/3/24 23:28
 **/
@Slf4j
public class RxConcatSubscribe {

    public void subscribe(){
        Observable.concat(Observable.create(new RxConcatObservableFirst()),
                Observable.create(new RxConcatObservableSecond()))
                .subscribe(new RxConcatObserver());
    }

    public void asyncSubscribe(){
        Observable.concat(Observable.create(new RxConcatObservableFirst()),
                Observable.create(new RxConcatObservableSecond()))
                .subscribeOn(Schedulers.from(ThreadPoolHolder.getCachedPoll()))
                .observeOn(Schedulers.from(ThreadPoolHolder.getFixPoll()))
                .subscribe(new RxConcatObserver());
    }

}
