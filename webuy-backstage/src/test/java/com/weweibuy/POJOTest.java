package com.weweibuy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName POJOTest
 * @Author durenhao  ak514250@126.com
 * @Date 2018/10/1 10:45
 */
@Slf4j
public class POJOTest {

    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

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

    public void test11(){
        SynchronousQueue<Object> synchronousQueue = new SynchronousQueue<>();
    }


}
