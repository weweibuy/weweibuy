package com.weweibuy;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @ClassName ProducerRunnable
 * @Description
 * @Author durenhao
 * @Date 2019/2/24 17:38
 **/
@Slf4j
@NoArgsConstructor
public class ProducerRunnable implements Runnable, Comparator<Human> {

    private static final String name = "明刚红李刘吕赵黄王孙朱曾游丽吴昊周郑秦丘";

    private PriorityBlockingQueue<Human> queue;

    private Random random = new Random();

    public ProducerRunnable(PriorityBlockingQueue<Human> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i ++){
            Human human = new Human("小" + name.charAt(i), random.nextInt(10000));
            queue.put(human);
            log.info(human.getName() + " 开始排队...");
        }
    }

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getMoney() - o2.getMoney();
    }
}
