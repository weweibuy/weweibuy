package com.weweibuy.webuy.learning.spring.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class ReactorFluxTest {

    @Test
    public void test01() throws InterruptedException {

        SampleSubscriber<Integer> ss = new SampleSubscriber<Integer>();
        Flux<Integer> ints = Flux.range(1, 4);
        ints.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error " + error),
                () -> {
                    System.out.println("Done");
                },
                s -> ss.request(10));
        ints.subscribe(ss);
        Thread.sleep(200);
    }


    @Test
    public void test02() {
        Flux<String> flux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });
        flux.subscribe(System.out::println);
        flux.subscribe(log::info);
    }

    @Test
    public void test03() {

        MyEventProcessor myEventProcessor = new MyEventProcessor();

        Flux<String> bridge = Flux.create(sink -> {
            myEventProcessor.register(
                    new MyEventListener<String>() {

                        public void onDataChunk(List<String> chunk) {
                            for (String s : chunk) {
                                log.error(s);
                                sink.next(s);
                            }
                        }

                        public void processComplete() {
                            sink.complete();
                        }
                    });
        }, FluxSink.OverflowStrategy.ERROR);

        bridge.subscribe(log::error);
        MyEventListener listener = myEventProcessor.getListener();

        String[] arr = {"1", "a", "2", "b"};

        listener.onDataChunk(Arrays.asList(arr));

    }


    @Test
    public void test04() {

        MyEventProcessor myEventProcessor = new MyEventProcessor();

        Flux<String> bridge = Flux.create(sink -> {
            myEventProcessor.register2(new SingleThreadEventListener<String>() {
                public void onDataChunk(List<String> chunk) {
                    for (String s : chunk) {
                        sink.next(s);
                    }
                }

                public void processComplete() {
                    sink.complete();
                }

                public void processError(Throwable e) {
                    sink.error(e);
                }

            });
        }, FluxSink.OverflowStrategy.ERROR);

        bridge.subscribe(log::info, i -> {
            log.error(i.getMessage());
        }, () -> {
            log.info("完成");
        });
        SingleThreadEventListener listener = myEventProcessor.getSingleThreadEventListener();

        String[] arr = {"1", "a", "2", "b"};

        listener.onDataChunk(Arrays.asList(arr));
        listener.processError(new RuntimeException("出错了"));
        listener.processComplete();

    }


    @Test
    public void test05() throws InterruptedException {
        MessageProcessor myMessageProcessor = new MessageProcessor();
        Flux<String> bridge = Flux.create(sink -> {
            myMessageProcessor.register(
                    new MyMessageListener<String>() {

                        public void onMessage(List<String> messages) {
                            for (String s : messages) {
                                sink.next(s);
                            }
                        }
                    });
            sink.onRequest(n -> {
                List<String> messages = myMessageProcessor.request(n);
                for (String s : messages) {
                    log.info(s + "     request");
                    sink.next(s);
                }
            });
        });

        bridge.subscribe(log::error);

        MyMessageListener listener = myMessageProcessor.getListener();
        String[] arr = {"1", "a", "2", "b"};
        listener.onMessage(Arrays.asList(arr));
        myMessageProcessor.request(1L);
        myMessageProcessor.request(1L);
        myMessageProcessor.request(1L);
        myMessageProcessor.request(1L);
        Thread.sleep(100);
    }


    @Test
    public void test06() {
        Mono.just("1")
                .subscribe(log::info);
    }

    @Test
    public void test07() {
        Flux.just(1, 2)
                .concatWith(Mono.just(1111))
                .onErrorReturn(0)
                .subscribe(System.out::println);
    }

    @Test
    public void test08() {
        Flux.just(1, 2)
                .concatWith(Mono.error(new RuntimeException()))
                .onErrorReturn(1000001)
                .subscribe(System.out::println);
    }

    @Test
    public void test09() throws InterruptedException {
        Flux.just(1, 2)
                .publishOn(Schedulers.single())
                .concatWith(Mono.just(1111))
                .concatWith(Mono.error(new IllegalArgumentException("cuowu le ")))
                .onErrorResume(e -> { // onErrorResume 在错误是返回 一个值
                    if (e instanceof IllegalStateException) {
                        return Mono.just(0);
                    } else if (e instanceof IllegalArgumentException) {
                        log.error(e.getMessage());
                        return Mono.empty();
                    }
                    return Mono.empty();
                })
                .then(Mono.just(2222)) // .then 不关心之前发出的, 只管我这个发出的
//                .doOnError(i -> {   // 处理错误不返回
//                    log.error("我这出错了");
//                })
                .subscribeOn(Schedulers.parallel())
                .subscribe(new MySubscribe());
        Thread.sleep(200);
    }

    @Test
    public void test10() throws InterruptedException {
        Mono.create(i -> {
            log.info("sink.....");
            i.success("1");
        })
                .concatWith(Mono.error(new RuntimeException("cuo le ")))


                .publishOn(Schedulers.single())
                .onErrorResume(e -> {
                    log.error(e.getMessage() + "xxxxx");
                    return Mono.just(22);
                })
                .then(Mono.just(2222)) // .then 不关心之前发出的, 只管我这个发出的; 但任然会执行 发射事件的代码
                .doOnError(i -> {
                    log.error("我这出错了");
                })
                .subscribeOn(Schedulers.parallel())
                .subscribe(new MySubscribe());
        Thread.sleep(200);
    }


    @Test
    public void test11(){
        Flux.just("1", "2")
                .compose(item -> {
                    item.subscribe(log::error);
                    return Mono.just(item);
                }).subscribe(i -> {
                    i.subscribe(log::error);
        });
    }

}