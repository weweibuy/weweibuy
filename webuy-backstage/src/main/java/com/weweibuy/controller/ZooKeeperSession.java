package com.weweibuy.controller;

/**
 * @ClassName ZooKeeperSession
 * @Description
 * @Author durenhao
 * @Date 2019/3/10 21:57
 **/
public class ZooKeeperSession {

    private ZooKeeperSession(){}

    private static class InnerHold{

        private static ZooKeeperSession zooKeeperSession = new ZooKeeperSession();
    }

    public static ZooKeeperSession getZooKeeperSession(){
        return InnerHold.zooKeeperSession;
    }

}
