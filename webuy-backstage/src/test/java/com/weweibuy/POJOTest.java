package com.weweibuy;

import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ClassName POJOTest
 * Author durenhao  ak514250@126.com
 * Date 2018/10/1 10:45
 */
@Slf4j
public class POJOTest {

    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    private static ForkJoinPool forkJoinPool = new ForkJoinPool();

    private static ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

    private static LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();

    private static PriorityBlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>();

    private static SynchronousQueue<String> stringSynchronousQueue = new SynchronousQueue<>();


    private static Integer count = 100;

    static ReentrantLock reentrantLock = new ReentrantLock();

    Semaphore semaphore = new Semaphore(3);


    @Test
    public void test02(){
        System.err.println( 1 + 2);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("1", "2");

        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.err.println("runnable");
            }
        };

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.err.println("callable");
                throw  new RuntimeException("xxxxxxx");
            }
        };

        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        try {
            futureTask.get();
        } catch (InterruptedException e) {


        } catch (ExecutionException e) {
            System.err.println(e.getMessage());
        }

    }

    @Test
    public void test03() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                count();
            }
        };
        for(int i = 0; i < 5; i++){
            threadPool.execute(runnable);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void count(){
        boolean locked = reentrantLock.isLocked();
        if(locked){
            try {
                reentrantLock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        reentrantLock.lock();
        count -- ;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println(count);
        reentrantLock.unlock();
    }


    @Test
    public  void  test4() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.weweibuy.POJOTest");
        Thread thread = new Thread();

        ReadWriteLock readWriteLock = new ReadWriteLock() {
            @Override
            public Lock readLock() {
                return null;
            }

            @Override
            public Lock writeLock() {
                return null;
            }
        };
    }

    @Test
    public void test5() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                countDownLatch.countDown();
                System.err.println(Thread.currentThread().getName());
                return null;
            }
        };

        for(int i = 0; i < 5; i++){
            threadPool.submit(callable);
        }
        countDownLatch.await();
        System.err.println("zzzzz");

    }

    @Test
    public void test6() throws Exception {
        Runnable qqqqqq = new Runnable() {
            @Override
            public void run() {
                log.info("qqqqqq");
            }
        };


        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3, qqqqqq);

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(100);
                log.info("...");
                cyclicBarrier.await();
                log.info(Thread.currentThread().getName());
                return null;
            }
        };
        for(int i = 0; i < 3; i++){
            threadPool.submit(callable);
        }
        Thread.sleep(5000);
    }

    @Test
    public void test7() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                semaphore.acquire(3);
                count1();
                semaphore.release(3);
                countDownLatch.countDown();
                return null;
            }
        };

        for(int i = 0; i < 10; i++){
            threadPool.submit(callable);
        }
        countDownLatch.await();
    }



    public void count1() throws Exception {
        AtomicInteger atomicInteger = new AtomicInteger();
        Thread.sleep(1511);
        log.info("数量减少为 {}",count);
        count --;
    }

    @Test
    public void test8(){
        int[] arr = {0, 1, 2, 5};
        int i = Arrays.binarySearch(arr, 5);
        log.info("索引为：{}", i);
    }

    @Test
    public void test9() throws InterruptedException {
        final ReentrantLock reentrantLock1 = new ReentrantLock();
        final ReentrantLock reentrantLock2 = new ReentrantLock();
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try{
                    reentrantLock1.lock();
                    Thread.sleep(1000);
                    reentrantLock2.lock();
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock1.unlock();
                    reentrantLock2.unlock();
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try{
                    reentrantLock2.lock();
                    Thread.sleep(1000);
                    reentrantLock1.lock();
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock2.unlock();
                    reentrantLock1.unlock();
                }
            }
        };
        threadPool.execute(runnable1);
        threadPool.execute(runnable2);
        countDownLatch.await();
    }

    @Test
    public void test10() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        Callable<String> stringCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("..........{}", count--);
                Thread.sleep(500);
                countDownLatch.countDown();
                return null;
            }
        };
        for(int i = 0; i < 100; i++){
            threadPool.submit(stringCallable);
        }
        countDownLatch.await();
    }

    @Test
    public void test11() throws Exception{
        ListeningExecutorService listeningExecutor = MoreExecutors.listeningDecorator(threadPool);
        System.err.println(Thread.currentThread().getName());
        ListenableFuture<String> future = listeningExecutor.submit(() -> {
            System.err.println(Thread.currentThread().getName());
            throw new RuntimeException("出错了");
        });
        future.addListener(() -> {
            System.err.println(Thread.currentThread().getName()  +" 坚挺到listeningExecutor 方法执行完成");
        }, threadPool);

        Futures.addCallback(future, new FutureCallback<String>() {

            @Override
            public void onSuccess(@Nullable String s) {
                System.err.println(Thread.currentThread().getName() + "  listeningExecutor 执行成功; 结果： " + s);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.err.println(Thread.currentThread().getName() + "  listeningExecutor 执行失败");
                log.error(throwable.getMessage());
            }
        }, threadPool);

        Thread.sleep(2000);

    }

    @Test
    public void test12()  {
        SettableFuture<Object> settableFuture = SettableFuture.create();
        ListeningExecutorService listeningExecutor = MoreExecutors.listeningDecorator(threadPool);
        ListenableFuture<String> future = listeningExecutor.submit(() -> {
            log.info("listeningExecutor 开始执行了");
            String res = "123";
            Thread.sleep(3000);
            settableFuture.set(res);
            return res;
        });

        String s = null;
        try {
            s = future.get(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            log.error("等待超时");
        }
        log.info("获取 future 的结果 {}", s);

    }

    @Test
    public void test13() throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.create(5);
        CountDownLatch countDownLatch = new CountDownLatch(20);

        for(int i = 0; i < 20; i++ ){
            threadPool.submit( () -> {
                rateLimiter.acquire();
                log.info(Thread.currentThread().getName());
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
    }

    @Test
    public void test14() throws Exception {
        RateLimiter rateLimiter = RateLimiter.create(5);
        CountDownLatch countDownLatch = new CountDownLatch(100);

        for(int i = 0; i < 100; i++ ){
            threadPool.submit( () -> {
                boolean b = rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS);
                log.info("开始");
                if(b){
                    log.info("秒杀成功");
                }else {
                    log.error("秒杀失败");
                }
                countDownLatch.countDown();
                return "";
            });
        }
        countDownLatch.await();
    }

    @Test
    public void test15() throws Exception {
        long timeMillis = System.currentTimeMillis();
        System.err.println(timeMillis);
        ForkJoinTask<Integer> submit = forkJoinPool.submit(new RecursiveTaskTest(0, 8));
        Integer sum = submit.get();
        long timeMillis2 = System.currentTimeMillis();
        log.info("结果 {} , 用时 {} " , sum, timeMillis2 - timeMillis);
        Thread.sleep(1000);
    }

    @Test
    public void test16() throws InterruptedException {
        long timeMillis = System.currentTimeMillis();
        int sum = 0;
        for(int i = 0; i <= 10; i++) {
            Thread.sleep(300);
            sum += i;
        }
        long timeMillis2 = System.currentTimeMillis();
        log.info("结果 {} , 用时 {} " , sum, timeMillis2 - timeMillis);
    }

    @Test
    public void test17() throws Exception {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
//        arrayBlockingQueue.offer("123");
        log.info("准备放入");
        for(int i = 0; i < 10; i++){
            boolean offer = arrayBlockingQueue.offer(i + "", 1000, TimeUnit.MICROSECONDS);
            log.info(offer + "");
        }
        log.info("offer 完成");
        String s = arrayBlockingQueue.poll();
//        String s = arrayBlockingQueue.take();
        log.info(s);
    }

    @Test
    public void test18(){
        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();
        for(int i = 10; i > 0; i--){
            priorityBlockingQueue.offer(i);
        }
        for(int i = 0; i < 10; i++){
            Integer poll = priorityBlockingQueue.poll();
            log.info(poll + "");
        }
    }

    @Test
    public void test19() throws Exception {
        PriorityBlockingQueue<Human> priorityBlockingQueue = new PriorityBlockingQueue<>(20, new ProducerRunnable());
        threadPool.execute(new ProducerRunnable(priorityBlockingQueue));
        Thread.sleep(1000);
        threadPool.execute(new ConsumerRunnable(priorityBlockingQueue));
        Thread.sleep(1000);
    }

    @Test
    public void test20(){
        LocalDate localDate = LocalDate.of(2008, 2, 3);
        log.info(localDate.toString());
        LocalDate now = LocalDate.now();
        LocalDate minus = now.minus(1, ChronoUnit.YEARS);
        log.info(minus.toString());
        LocalDate plus = now.plus(1, ChronoUnit.WEEKS);
        log.info(plus.toString());

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        String format = dateTime.format(pattern);
        log.info(format);

        LocalDateTime parse = LocalDateTime.parse("2019-02-26 23:18:11", pattern);
        log.info(parse.toString());
        Instant instant = Instant.now();

        Period between = Period.between(minus, plus);
        int days = between.getDays();
        int years = between.getYears();
        int months = between.getMonths();
        log.info("{} {} {}", days, years, months);
    }

    @Test
    public void test21(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int limit = countStep(list.size());
        List<List<Integer>> splitList = Stream.iterate(0, n -> n + 1).limit(limit).parallel().map(
                a -> list.stream().skip(a * 3).limit(2).parallel().collect(Collectors.toList())).collect(Collectors.toList());

        System.out.println(splitList);
    }

    private static Integer countStep(Integer size) {
        return (size + 3 - 1) / 3;
    }

}
