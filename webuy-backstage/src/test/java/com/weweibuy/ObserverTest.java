package com.weweibuy;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @ClassName ObserverTest
 * @Description
 * @Author durenhao
 * @Date 2019/3/24 17:49
 **/
@Slf4j
public class ObserverTest {

    private static final Executor fixPool = Executors.newFixedThreadPool(4);

    private static final Executor cachePool = Executors.newCachedThreadPool();


    @Test
    public void test(){

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1111);
                e.onNext(2222);
                e.onNext(3333);
            }
        }).map(new Function<Integer,String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                log.info("This is a map demo,id= {}", integer);
                return "This is a map demo,id= "+ integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                log.error(s);
            }
        });

    }

    @Test
    public void test02() throws InterruptedException {
        Observable.create(new ObservableOnSubscribe<Integer>() { // 第一步：初始化Observable
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
               log.info( "Observable emit 1" + "\n");
                e.onNext(1);
               log.info( "Observable emit 2" + "\n");
                e.onNext(2);
               log.info( "Observable emit 3" + "\n");
                e.onNext(3);
                e.onComplete();
               log.info( "Observable emit 4" + "\n" );
                e.onNext(4);
            }
        }).subscribe(new Observer<Integer>() { // 第三步：订阅

            // 第二步：初始化Observer
            private int i;
            private Disposable mDisposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                log.error(integer + "");
                i++;
                if (i == 2) {
                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
                    mDisposable.dispose();
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
               log.info( "onError : value : " + e.getMessage() + "\n" );
            }

            @Override
            public void onComplete() {
               log.error( "onComplete" + "\n" );
            }
        });
        Thread.sleep(110);
    }


    /**
     * 异步场景  --- 异步发射
     * @throws InterruptedException
     */
    @Test
    public void test03() throws InterruptedException {
         CountDownLatch countDownLatch = new CountDownLatch(10);

        for(int i = 0; i < 10; i++){

            Observable.create(new ObservableOnSubscribe<Integer>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                    countDownLatch.countDown();
                    Thread.sleep(100);
                    log.info( "被观察者的发射线程 : " + Thread.currentThread().getName());
                    e.onNext(111111111);
                    log.error("被观察者 休息一下");
                    Thread.sleep(2000);
                    log.error("被观察者 休息好了");
                    e.onComplete();
                }
            }).subscribeOn(Schedulers.from(cachePool)) // 定义发射线程
                    .observeOn(Schedulers.from(fixPool)) // 定义观察者线程
                    .doOnNext(new Consumer<Integer>() {
                        @Override
                        public void accept(@NonNull Integer integer) throws Exception {
                            log.error(integer + "");
                            log.info( "After observeOn(mainThread)，Current thread is " + Thread.currentThread().getName());
                        }
                    })
                    .observeOn(Schedulers.io()) //  定义第二个观察者的线程
                    .subscribe(new Consumer<Integer>() {
                        @Override
                        public void accept(@NonNull Integer integer) throws Exception {
                            log.error(integer + "。。。。。");
                            log.info( "After observeOn(io)，Current thread is " + Thread.currentThread().getName());
                        }
                    });
        }
        log.error("主线程等待任务完成");
        countDownLatch.await();
        Thread.sleep(3000);
    }



}
