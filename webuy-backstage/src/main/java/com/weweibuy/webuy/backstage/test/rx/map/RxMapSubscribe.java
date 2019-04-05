package com.weweibuy.webuy.backstage.test.rx.map;

import com.weweibuy.webuy.backstage.thead.ThreadPoolHolder;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

/**
 * 通过map映射 转化
 * @ClassName RxMapSubscribe
 * @Description
 * @Author durenhao
 * @Date 2019/3/24 22:56
 **/
@Slf4j
public class RxMapSubscribe {

    public void subscribe(){
        Observable.create(new RxMapObservable())
                .map(new RxMapFunction()).subscribe(new RxMapObserver());
    }

    public void asyncSubscribe(){

        Observable.create(new RxMapObservable())
                .subscribeOn(Schedulers.from(ThreadPoolHolder.getCachedPoll()))
                .observeOn(Schedulers.from(ThreadPoolHolder.getFixPoll()))
                .map(new RxMapFunction()).subscribe(new RxMapObserver());
    }

}
