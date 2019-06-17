package com.weweibuy.webuy.learning.sharing.service;

import com.weweibuy.webuy.learning.sharing.utils.HashUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TimeOrderServiceTest {

    public static int seed = 31;

    private static final String str = "12dfsfdsfdsfsdfsvcxknck515";

    @Test
    public void testHash() throws Exception {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            int hashCode = HashUtil.FNVHash1(str);
        }
        log.error("用时: {}", System.currentTimeMillis() - l);
    }


}