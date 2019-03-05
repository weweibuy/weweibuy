package com.weweibuy;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RecursiveTask;

/**
 * @ClassName RecursiveTaskTest
 * @Description
 * @Author durenhao
 * @Date 2019/2/24 10:35
 **/
@Slf4j
public class RecursiveTaskTest extends RecursiveTask<Integer> {

    public static final int threshold = 2;

    private int start;

    private int end;

    public RecursiveTaskTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= threshold;
        if(canCompute) {
            log.info("小于阈值");
            //如果小于阈值，就进行运算
            for(int i = start; i<= end; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum += i;
            }
        }else {
            int middle = (start + end)/2;
            log.info("大于于阈值");
            RecursiveTaskTest leftTask = new RecursiveTaskTest(start, middle);
            RecursiveTaskTest rightTask = new RecursiveTaskTest(middle + 1, end);

//            leftTask.fork();
//            rightTask.fork();

//            rightTask.fork();
//            Integer compute = leftTask.compute();
//            Integer join = rightTask.join();
//            sum = compute + join;
            invokeAll(leftTask, rightTask);
            sum = rightTask.join() + leftTask.join();
        }

        return sum;
    }
}
