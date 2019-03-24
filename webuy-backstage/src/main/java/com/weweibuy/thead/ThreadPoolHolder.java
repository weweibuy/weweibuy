package com.weweibuy.thead;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadPoolHolder
 * @Description
 * @Author durenhao
 * @Date 2019/3/24 22:16
 **/
public class ThreadPoolHolder {

    private ThreadPoolHolder(){}

    private static class InnerHolder{

        private static final Executor FIX_POOL = Executors.newFixedThreadPool(4);

        private static final Executor CACHED_POOL = Executors.newCachedThreadPool();
    }

    public static Executor getFixPoll(){
        return InnerHolder.FIX_POOL;
    }

    public static Executor getCachedPoll(){
        return InnerHolder.CACHED_POOL;
    }


}
