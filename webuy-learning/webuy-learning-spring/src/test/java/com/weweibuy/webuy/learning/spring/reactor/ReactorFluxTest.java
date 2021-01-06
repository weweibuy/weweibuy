package com.weweibuy.webuy.learning.spring.reactor;

import com.weweibuy.webuy.learning.spring.hystirx.HealthCounts;
import com.weweibuy.webuy.learning.spring.hystirx.HystrixEvent1;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.reactivestreams.Subscription;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import reactor.core.publisher.*;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class ReactorFluxTest {

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    private ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    {
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setThreadNamePrefix("reactor-flux-test-");
        executor.initialize();
    }

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

                        public void onDataChunk(String chunk) {
                            sink.next(chunk);
                        }

                        public void processComplete() {
                            sink.complete();
                        }
                    });
        }, FluxSink.OverflowStrategy.ERROR);

        bridge
                .subscribe(log::error);
        MyEventListener listener = myEventProcessor.getListener();

        String[] arr = {"1", "a", "2", "b"};

        for (String s : arr) {
            listener.onDataChunk(s);
        }

    }


    @Test
    public void test04() throws InterruptedException {

        MyEventProcessor myEventProcessor = new MyEventProcessor();

        Flux<String> bridge = Flux.create(sink -> {
            myEventProcessor.register2(new SingleThreadEventListener<String>() {
                public void onDataChunk(List<String> chunk) {
                    try {
                        for (String s : chunk) {
                            sink.next(s);
                            throw new RuntimeException("内部错误");
                        }
                    } catch (Exception e) {
                        sink.error(e);
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

        bridge.publishOn(Schedulers.fromExecutor(executor))
                .doOnComplete(() -> {
                    log.info(".... 完成了");
                })
                .doOnError(i -> {
                    log.info(".... 出错了");
                })
                .subscribe(log::info, i -> {
                    log.error(i.getMessage());
                }, () -> {
                    log.info("完成");
                });
        SingleThreadEventListener listener = myEventProcessor.getSingleThreadEventListener();

        String[] arr = {"1", "a", "2", "b"};

        listener.onDataChunk(Arrays.asList(arr));
//        listener.processError(new RuntimeException("出错了"));
        listener.processComplete();
        Thread.sleep(1000);
    }


    @Test
    public void test05() throws InterruptedException {
        MessageProcessor myMessageProcessor = new MessageProcessor();
        Flux<String> bridge = Flux.<String>create(sink -> {
            myMessageProcessor.register(
                    new MyMessageListener<String>() {

                        public void onMessage(String messages) {
                            sink.next(messages);
                        }

                        @Override
                        public void onEventStopped() {
                            log.info("发布事件完成");
                            sink.complete();
                        }
                    });
        }, FluxSink.OverflowStrategy.BUFFER)
                .doOnRequest(n -> {
                    log.info("收到请求: {}", n);
                })
                .publishOn(Schedulers.newSingle("newSingle"), 1);

        bridge.subscribe(new BaseSubscriber<String>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                request(1);
            }

            @Override
            protected void hookOnNext(String value) {
                log.info("【收到消息】：{}", value);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                request(1);
            }

            @Override
            protected void hookOnComplete() {
                log.info("订阅事件完毕");
                countDownLatch.countDown();

            }


        });

        MyMessageListener listener = myMessageProcessor.getListener();

        executor.submit(() -> {
            Stream.iterate(0, n -> n + 1)
                    .limit(10)
                    .map(i -> i + "")
                    .forEach(i -> {
                        listener.onMessage(i);
                        log.warn("【发送消息】: {}", i);
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
            listener.onEventStopped();
        });
        countDownLatch.await();

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
    public void test11() {
        Mono.just("1")
                .compose(item -> {
                    item.doOnSuccess(i -> {
                        log.info("成功了" + i);
                    });
                    Mono<String> stringMono = item.
                            doOnSuccess(i -> {
                                log.info("成功了" + i);
                            });
                    stringMono.subscribe(it -> {
                        log.info("订阅..");
                    });
                    return stringMono;

                })
                .doOnSuccess(i -> {
                    log.info("又成功了" + i);
                })
                .doOnSuccess(i -> {
                    log.info("又又成功了" + i);
                })
                .subscribe(log::info);
    }

    @Test
    public void test12() throws InterruptedException {

        UnicastProcessor<Integer> processor = UnicastProcessor.create();
        FluxSink<Integer> sink = processor.sink(FluxSink.OverflowStrategy.BUFFER);

        processor.doOnError(e -> {
            log.error(e.getMessage());
        });
        processor.subscribeOn(Schedulers.parallel());
        processor.subscribe(i -> {
            log.info(i + "");
        });

        for (int i = 0; i < 100; i++) {
            if (i == 88) {
                sink.error(new RuntimeException("chu cuo le"));
            }
            sink.next(i);
        }
        Thread.sleep(200);
    }


    @Test
    public void test14() throws InterruptedException {
        Flux<Integer> source = Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("subscribed to source"));

        ConnectableFlux<Integer> co = source.publish();

        co.subscribe(System.out::println, e -> {
        }, () -> {
        });
        co.subscribe(System.out::println, e -> {
        }, () -> {
        });

        System.out.println("done subscribing");
        Thread.sleep(500);
        System.out.println("will now connect");

        co.connect();
    }

    @Test
    public void test15() {
        String key = "message";
        Mono.just("Hello")
                .flatMap(s -> Mono.subscriberContext()
                        .map(ctx -> s + " " + ctx.get(key)))
                .subscriberContext(ctx -> ctx.put(key, "World"))
                .subscribe(log::error);

    }

    @Test
    public void test16() {

        Flux.just("1", "2", "3", "4", "5")
                .window(2, 2)
                .concatMap(g -> g.defaultIfEmpty("-1"))
                .subscribe(log::error);
    }

    @Test
    public void test17() throws InterruptedException {
        MyEventProcessor myEventProcessor = new MyEventProcessor();

        Flux.<String>create(sink -> {
            myEventProcessor.register(
                    new MyEventListener<String>() {
                        public void onDataChunk(String chunk) {
                            sink.next(chunk);
                        }

                        public void processComplete() {
                            sink.complete();
                        }
                    });
        }, FluxSink.OverflowStrategy.DROP)
//                .concatMap(g -> g.singleOrEmpty())
                .windowTimeout(99, Duration.ofMillis(200))

                .flatMap(g -> {
                    return g.count();
                }).doOnNext(i -> {
            log.info(i + "000");
        })
//                                .window(1, 20)
////                .windowWhen()
//
//                .flatMap(g -> {
////                    g.subscribe(i -> {
//                    log.info("窗口2: {}");
////                    });
//                    return g.singleOrEmpty();
//                })
//                .startWith("999999")
                .subscribe(i -> {
                    log.info(i + "");
                });

        for (int i = 0; i < 100; i++) {
            myEventProcessor.push(i + "");
            Thread.sleep(10);
        }
        Thread.sleep(200);
    }


    @Test
    public void test18() {
        Flux.just(1, 3, 5, 2, 4, 6, 11, 12, 13)
                .windowWhile(i -> i % 2 == 0)
                .concatMap(g -> g.defaultIfEmpty(-99999))
                .subscribe(i -> {
                    log.info(i + "");
                });
    }


    @Test
    public void test19() {
        MyEventProcessor myEventProcessor = new MyEventProcessor();

        Flux.<String>create(sink -> {
            myEventProcessor.register(
                    new MyEventListener<String>() {
                        public void onDataChunk(String chunk) {
                            sink.next(chunk);
                        }

                        public void processComplete() {
                            sink.complete();
                        }
                    });
        }, FluxSink.OverflowStrategy.DROP);
    }

    @Test
    public void test20() {
        Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .window(100, 100)

                .flatMap(i -> {
                    // 聚合  初始化为100;
                    return i.scan(100, new BiFunction<Integer, Integer, Integer>() {
                        @Override
                        public Integer apply(Integer integer, Integer integer2) {
                            log.error("元素 1: {} ; 元素 2: {} ;", integer, integer2);
                            // 上一个流元素加上当前元素
                            return integer + integer2;
                        }
                    });
                })
                .subscribe(i -> {
                    log.info(i + "");
                });
    }


    @Test
    public void test21() {
        Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .window(100, 100)
                .flatMap(i -> {
                    // 聚合  初始化为100;
                    return i.reduce(new BiFunction<Integer, Integer, Integer>() {
                        @Override
                        public Integer apply(Integer integer, Integer integer2) {
                            log.error("元素 1: {} ; 元素 2: {} ;", integer, integer2);
                            // 上一个流元素加上当前元素
                            return integer + integer2;
                        }
                    });
                })
                .subscribe(i -> {
                    log.info(i + "");
                });
    }


    @Test
    public void test22() throws InterruptedException {


        // 线程安全的
        EmitterProcessor<Integer> processor = EmitterProcessor.<Integer>create();
        FluxSink<Integer> sink = processor.sink(FluxSink.OverflowStrategy.BUFFER);


        Flux<Integer> share = processor.share();


        share
                // 一100ms为一个维度将数据全部累加; 然后发射
                .window(Duration.ofMillis(100))
                .flatMap(i -> {
                    return i.reduce(new BiFunction<Integer, Integer, Integer>() {
                        @Override
                        public Integer apply(Integer integer, Integer integer2) {
                            return integer + integer2;
                        }
                    });
                })

                // 以10个数据为一个维度, 然后跳过10个数据(也就是前面的10个)
                .window(10, 1)
                .flatMap(i -> {
                    // 将数据累加; 然后立即发送
                    return i.scan(new BiFunction<Integer, Integer, Integer>() {
                        @Override
                        public Integer apply(Integer integer, Integer integer2) {
                            log.error(integer + "" + integer2 + "");
                            return integer + integer2;
                        }
                    }).skip(10);
                })
                .doOnSubscribe(i -> {
                    log.info("产生订阅");
                })
                .subscribe(i -> {
                    log.info(i + "");
                });
        try {
            for (int i = 0; i < 100; i++) {
                if (i == 10) {
                    throw new RuntimeException("");
                }
                sink.next(i);
            }
        } catch (Exception e) {

        }

        for (int i = 110; i < 200; i++) {
            sink.next(i);
            Thread.sleep(50);
        }

        Thread.sleep(3000);

    }


    @Test
    public void test24() throws InterruptedException {
        EmitterProcessor<HystrixEvent1> processor = EmitterProcessor.<HystrixEvent1>create();

        FluxSink<HystrixEvent1> sink = processor.sink(FluxSink.OverflowStrategy.DROP);


        Flux<HystrixEvent1> share = processor.share();

        processor
                .window(Duration.ofMillis(2000))
                .flatMap(i -> {
                    return i.reduce(new HealthCounts(), new BiFunction<HealthCounts, HystrixEvent1, HealthCounts>() {

                        @Override
                        public HealthCounts apply(HealthCounts healthCounts, HystrixEvent1 hystrixEvent1) {
                            log.info("HealthCounts: {};  hystrixEvent1: {}", healthCounts.getTotalCount(), hystrixEvent1.getStartTimestamp());
                            healthCounts.setTotalCount(hystrixEvent1.getStartTimestamp());
                            return healthCounts;
                        }
                    });
                })
                .startWith(new ArrayList<>())
                .window(10, 1)
                .flatMap(i -> {
                    return i.scan(new HealthCounts(), new BiFunction<HealthCounts, HealthCounts, HealthCounts>() {

                        @Override
                        public HealthCounts apply(HealthCounts healthCounts, HealthCounts healthCounts2) {
                            log.error("HealthCounts: {};  healthCounts2: {}", healthCounts.getTotalCount(), healthCounts2.getTotalCount());
                            healthCounts.setTotalCount(healthCounts2.getTotalCount() + 100);
                            return healthCounts;
                        }
                    })
                            .skip(10); // 忽略不不完整的窗口
                })
                .share()
                .subscribeOn(Schedulers.fromExecutor(executor))
                .subscribe(i -> {
                    long totalCount = i.getTotalCount();
                    log.warn("总计数量: {} ", totalCount);
                });
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                sink.next(HystrixEvent1
                        .builder()
                        .startTimestamp(10 + i)
                        .build());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        Thread.sleep(1000);

    }


    @Test
    public void test25() throws Exception {
        Flux.just("1", "2", "3", "4", "5", "6")
                .publishOn(Schedulers.fromExecutor(executor))
                .subscribe(log::info);
    }


    @Test
    public void test26() throws Exception {
        Flux.just("tom", "tom1", "tom2")
                .map(s -> {
                    log.info("[map] 数据");
                    return s.concat("@mail.com");
                })
                .publishOn(Schedulers.newElastic("thread-publishOn"))
                .filter(s -> {
                    log.info("[filter] 数据");
                    return s.startsWith("t");
                })
                .subscribeOn(Schedulers.newElastic("thread-subscribeOn"))
                .subscribe(s -> {
                    log.info("[subscribe] 数据: {}", s);
                });
        Thread.sleep(200);
    }


    /*8
    并行
     */
    @Test
    public void test27() {
        Flux.range(1, 10)
                .parallel(2)
                .runOn(Schedulers.fromExecutor(executor))
                .subscribe(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));
    }


    @Test
    public void test28() {
        AtomicInteger integer = new AtomicInteger();
        Flux.range(1, 10000)
                .window(100, 100)
                .flatMap(i -> {
                    return i.reduce(integer, (a, f) -> {
                        a.addAndGet(f);
                        return a;
                    });
                })
                .reduce((a, b) -> {
                    return b;
                })
                .subscribe(i -> {
                    int i1 = i.get();
                    log.info("总数: {}", i1);
                });

    }

    @Test
    public void test29() throws InterruptedException {
        List<String> strings = new ArrayList<>();
        strings.add("tom");
        strings.add("jack");

        List<String> strings2 = new ArrayList<>();
        strings2.add("lucy");
        strings2.add("jim");

        ArrayList<List<String>> lists = new ArrayList<>();
        lists.add(strings);
        lists.add(strings2);

        Flux.fromStream(lists.stream())
                .flatMap(list -> {
                    return Flux.fromStream(list.stream());
                })
                .subscribe(log::info);
    }

    @Test
    public void test30() throws InterruptedException {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 1; i <= 1001; i++) {
            integers.add(i);
        }

        Long count = 0L;

        Flux.fromStream(integers.stream())
                .window(100, 100)
                .flatMap(i -> {
                    return i.collectList();
                })
                .parallel(3)
                .runOn(Schedulers.fromExecutor(executor))
                .map(i -> {
                    return i.stream().collect(Collectors.summarizingInt(value -> value));
                })
                .doOnNext(i -> {
                    log.info("总和: {}", i.getSum());
                })
                .sequential()
                .reduce(count, (a, b) -> {
                    log.info("计算");
                    return a + b.getSum();
                })
                .doOnNext(i -> {
                    log.info("结果总和: {}", i);
                })
                .subscribe();
        Thread.sleep(1000);
    }


    @Test
    public void test31() {
        List<String> stringList = Stream.iterate(0, n -> n + 1)
                .limit(10)
                .map(i -> i + "")
                .collect(Collectors.toList());

        Flux.fromIterable(stringList)
                .doOnNext(log::info)
                .map(i -> i + " A")
                .subscribe(log::error);
    }



}