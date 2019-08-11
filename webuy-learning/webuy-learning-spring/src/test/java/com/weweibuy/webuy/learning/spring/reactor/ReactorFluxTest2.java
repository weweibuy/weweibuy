package com.weweibuy.webuy.learning.spring.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CountDownLatch;

/**
 * @author durenhao
 * @date 2019/8/9 22:52
 **/
@Slf4j
public class ReactorFluxTest2 {

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    private ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    {
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setThreadNamePrefix("reactor-flux-test-");
        executor.initialize();
    }


    @Test
    public void test01() throws Exception{

    }

}
