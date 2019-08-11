package com.weweibuy.webuy.learning.sharing.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author durenhao
 * @date 2019/8/10 21:44
 **/
@Slf4j
public class RandomTest {


    @Test
    public void test(){
        Stream.iterate(0, i -> i +1)
                .limit(50)
                .forEach(i -> {
                    int i1 = RandomUtils.nextInt(0, 6);
                    log.info("数字: {}", i1);
                });


    }

}
