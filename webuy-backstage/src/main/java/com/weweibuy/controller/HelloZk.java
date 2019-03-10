package com.weweibuy.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName HelloZk
 * @Description
 * @Author durenhao
 * @Date 2019/3/10 21:43
 **/
@Slf4j
@RestController
public class HelloZk {

    private static ZooKeeper zookeeper;

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

     static {
         try {
             zookeeper = new ZooKeeper("106.12.95.245:2181", 5000,
                     new ZooKeeperWatcher());
             log.info(zookeeper.getState().toString());
             String s = "";
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

     @RequestMapping("/zk/lock")
    public String helloZk(){
        try {
            zookeeper.create("/test-lock", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            log.info("成功创建节点.....");
        } catch (KeeperException e) { //  没有获取到锁
            e.printStackTrace();
            return "未获取到锁 KeeperException";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "未获取到锁 InterruptedException";
        }
        log.info("删除锁.....");
        try {
            zookeeper.delete("/test-lock", -1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "删除锁失败";
        } catch (KeeperException e) {
            e.printStackTrace();
            return "删除锁失败";
        }
        return "zk..";
    }

    private static class ZooKeeperWatcher implements Watcher{

        @Override
        public void process(WatchedEvent watchedEvent) {
            log.info(watchedEvent.getState().toString());
            if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
                log.info("connected.....");
            }else {
                log.info("unconnected!!!!");
            }

        }
    }

}
