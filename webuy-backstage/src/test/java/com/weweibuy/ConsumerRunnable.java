package com.weweibuy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @ClassName ConsumerRunnable
 * @Description
 * @Author durenhao
 * @Date 2019/2/24 17:48
 **/
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerRunnable implements Runnable {

    private PriorityBlockingQueue<Human> queue;

    @Override
    public void run() {
        while (true){
            Human human = queue.poll();
            if(human == null){
                break;
            }
            log.info("为 {} 办理业务, 资金 {}", human.getName(), human.getMoney());
        }
    }
}
