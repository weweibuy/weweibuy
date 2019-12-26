package com.weweibuy.webuy.learning.spring.thead;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author durenhao
 * @date 2019/12/9 21:18
 **/
@Slf4j
public class ForkJoinTest {

    private static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool(4);

    @Test
    public void test01() throws ExecutionException, InterruptedException {
        int i = (1 + 1000) * 1000 / 2;

        System.err.println(i);

        List<Integer> collect = Stream.iterate(1, n -> n + 1)
                .limit(1000)
                .collect(Collectors.toList());
        Spliterator<Integer> spliterator = collect.spliterator();

        long l = System.currentTimeMillis();
        Integer invoke = FORK_JOIN_POOL.invoke(new CountTask(spliterator));

//        ForkJoinTask<Integer> submit = FORK_JOIN_POOL.submit(new CountTask(spliterator));
//        ForkJoinTask<List<String>> submit1 = FORK_JOIN_POOL.submit(new StringTask(collect.spliterator()));
//        System.err.println(submit.get());
//        System.err.println(submit1.get().size());
        log.info("用时: {}", System.currentTimeMillis() - l);

    }

    private class CountTask extends RecursiveTask<Integer> {

        private final Spliterator<Integer> spliterator;

        private CountTask(Spliterator<Integer> spliterator) {
            this.spliterator = spliterator;
        }


        @Override
        protected Integer compute() {
            if (spliterator.estimateSize() <= 20) {
                IntegerWarper integerWarper = new IntegerWarper(0);
                spliterator.forEachRemaining(i -> {
                    log.info("计算 integer");
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    integerWarper.add(i);
                });
                return integerWarper.getInteger();
            } else {
                Spliterator<Integer> integerSpliterator = spliterator.trySplit();
                CountTask countTask = new CountTask(integerSpliterator);
                CountTask countTask2 = new CountTask(spliterator);
                invokeAll(countTask, countTask2);
                Integer join = countTask.join();
                Integer join1 = countTask2.join();
                return join + join1;
            }
        }
    }


    private class StringTask extends RecursiveTask<List<String>> {

        private final Spliterator<Integer> spliterator;

        private StringTask(Spliterator<Integer> spliterator) {
            this.spliterator = spliterator;
        }


        @Override
        protected List<String> compute() {
            if (spliterator.estimateSize() <= 20) {
                List<String> list = new ArrayList<>();
                spliterator.forEachRemaining(i -> {
                    log.info("计算 string");
                    try {
                        Thread.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add(i + "");
                });
                return list;
            } else {
                Spliterator<Integer> integerSpliterator = spliterator.trySplit();
                StringTask countTask = new StringTask(integerSpliterator);
                StringTask countTask2 = new StringTask(spliterator);
                invokeAll(countTask, countTask2);
                List<String> join = countTask.join();
                List<String> join1 = countTask2.join();
                join.addAll(join1);
                return join;
            }
        }
    }


    @Data
    @AllArgsConstructor
    private class IntegerWarper {

        private Integer integer;


        private void add(Integer i) {
            integer += i;
        }

    }


}
