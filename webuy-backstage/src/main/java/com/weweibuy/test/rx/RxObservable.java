package com.weweibuy.test.rx;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 被监听者
 * @ClassName RxDefObservable
 * @Description
 * @Author durenhao
 * @Date 2019/3/24 20:18
 **/
@Slf4j
public class RxObservable implements ObservableOnSubscribe<String> {

    @Override
    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
        int count = 0;
        String text = "hello rx ..." ;
        log.error("被观察者 发射 内容  {}", text + count++);
        emitter.onNext(text);
        emitter.onNext(text + count++);
        emitter.onNext(text + count++);
        emitter.onNext(text + count++);
//        Thread.sleep(1000);
        log.error("被观察者 业务完成了");
        // onComplete 将无法发射消息
//        emitter.onComplete();

        Thread.sleep(1000);

        log.error("被观察者出错了");
        emitter.onError(new IOException("io 异常了"));
        log.error("被观察者 快要完蛋了");
        emitter.onComplete();

    }
}
