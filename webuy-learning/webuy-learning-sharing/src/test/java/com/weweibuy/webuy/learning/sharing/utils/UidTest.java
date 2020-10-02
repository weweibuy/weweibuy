package com.weweibuy.webuy.learning.sharing.utils;

import com.baidu.fsg.uid.UidGenerator;
import com.weweibuy.framework.common.core.utils.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

/**
 * @author durenhao
 * @date 2019/8/10 20:10
 **/
@Slf4j
public class UidTest {

    public static final ThreadPoolTaskExecutor EXECUTOR = new ThreadPoolTaskExecutor();

    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1000000);

    @Autowired
    public UidGenerator uidGenerator;

    static {
        EXECUTOR.setCorePoolSize(10);
        EXECUTOR.setMaxPoolSize(10);
        EXECUTOR.initialize();
    }

    @Test
    public void test01() throws Exception {
        long nextId1 = IdWorker.nextId();
        long l = System.currentTimeMillis();
        System.err.println(l);
        Stream.iterate(0, n -> n + 1)
                .limit(1000000)
                .forEach(i -> {
                    EXECUTOR.execute(() -> {
                        IdWorker.nextId();
                        COUNT_DOWN_LATCH.countDown();
                    });
                });
        COUNT_DOWN_LATCH.await();
        log.info("用时: {}", System.currentTimeMillis() - l);
    }


}
