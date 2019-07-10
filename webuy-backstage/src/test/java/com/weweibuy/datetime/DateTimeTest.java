package com.weweibuy.datetime;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author durenhao
 * @date 2019/6/29 9:55
 **/
public class DateTimeTest {


    @Test
    public void test01() {
        // 当前时间格式化
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.err.println(format);

    }

    @Test
    public void test02(){
        int hour = LocalDateTime.now().getHour();
        System.err.println(hour);
        int hour1 = LocalDateTime.now().plusHours(1).getHour();
        int hour2 = LocalDateTime.now().plusHours(-1).getHour();
        System.err.println(hour1);
        System.err.println(hour2);


    }


    @Test
    public void test03(){
        // 当前时间秒值
        long l = System.currentTimeMillis();
        long l1 = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.err.println(l);
        System.err.println(l1);
    }

    @Test
    public void test04(){
        String str = "1986-04-08 12:30";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(str, dateTimeFormatter);


    }


}
