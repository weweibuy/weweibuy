package com.weweibuy.webuy.learning.sharing.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.stream.Stream;

@Slf4j
public class HashUtilTest {

    private static final String str = "hello";

    @Test
    public void FNVHash1() throws Exception {
        long l = System.currentTimeMillis();
//        Stream.iterate(0, n -> n + 1)
//                .limit(10000000)
//                .forEach(i -> HashUtil.FNVHash1(str + i));
//        log.info("用时: {}", System.currentTimeMillis() - l);
        int i = HashUtil.FNVHash1("12121212");
        System.err.println(i);
    }


    @Test
    public void Crc32() throws Exception {
        long l = System.currentTimeMillis();
        Stream.iterate(0, n -> n + 1)
                .limit(10000000)
                .forEach(i -> HashUtil.crc32(str + i));
        log.info("用时: {}", System.currentTimeMillis() - l);
    }

}