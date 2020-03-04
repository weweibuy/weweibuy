/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learning.spring.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author durenhao
 * @date 2019/6/28 15:52
 **/
@Slf4j
public class TimeTest {


    @Test
    public void test01() {
        long l = TimeUnit.SECONDS.toMillis(1593140031L);
        System.err.println(l);
        Date date = new Date(l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.err.println(simpleDateFormat.format(date));
        System.err.println(l < System.currentTimeMillis());
    }


    @Test
    public void test02() {
    }


    @Test
    public void test03(){

    }


}
