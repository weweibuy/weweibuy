package com.weweibuy.webuy.learning.spring.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TestVo1Test {

    private ExecutorService executorService = Executors.newFixedThreadPool(20);


    @Test
    public void convert() throws Exception {
        TestVo1 testVo1 = new TestVo1();
        testVo1.setName("tom");
        testVo1.setAge(12);
        testVo1.setBillNo("121fsdgfdggregr");
        testVo1.setList(Collections.singletonList(new TestDog(155, "jack")));

        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                Thread.sleep(10);
                for (int j = 0; j < 20; j++) {
                    TestVo2 convert = TestVo1.convert(testVo1);
                    if (convert.getAge() != 12 || !convert.getName().equals("tom") ||
                            convert.getList().get(0).getAge() != 155 ||
                            !convert.getList().get(0).getColor().equals("jack")) {
                        log.error("错误");
                    }
                }
                Thread.sleep(10);
                return null;
            });
        }
        Thread.sleep(200);
    }

}