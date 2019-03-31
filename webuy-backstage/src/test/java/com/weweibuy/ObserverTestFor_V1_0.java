package com.weweibuy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * @ClassName ObserverTestFor_V1_0
 * @Description
 * @Author durenhao
 * @Date 2019/3/25 22:52
 **/
@Slf4j
public class ObserverTestFor_V1_0 {

    @Test
    public void test(){
        Observable.just("Hello", "World")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        log.error(s);
                    }
                });
    }

    @Test
    public void test2(){

        final Action0 onCompletedAction  = new Action0() {
            @Override
            public void call() {
                System.err.println("call");
            }
        };

        final Action1<Integer> onNextAction  = new Action1<Integer>() {
            @Override
            public void call(Integer s) {
                log.error(s +"");
            }
        };

        final Action1<Integer> onErrorAction  = new Action1<Integer>() {
            @Override
            public void call(Integer s) {
                log.error(s + "");
            }
        };

        Func0<Observable<Integer>> func0 = new Func0<Observable<Integer>>() {
            @Override
            public Observable<Integer> call() {
                return null;
            }
        };

        Func1<Integer, String> func1 = new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return null;
            }
        };

        Observable<Integer> defer = Observable.defer(func0);
    }


}
