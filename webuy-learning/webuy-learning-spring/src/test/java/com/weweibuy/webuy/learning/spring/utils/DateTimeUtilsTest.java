package com.weweibuy.webuy.learning.spring.utils;

import com.weweibuy.webuy.common.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
public class DateTimeUtilsTest {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Test
    public void dateToLocalDateTime() throws Exception {

        Date date = new Date();
        LocalDateTime localDateTime = DateTimeUtils.dateToLocalDateTime(date);
        String format = localDateTime.format(dateTimeFormatter);

        Date date1 = DateTimeUtils.localDateTimeToDate(localDateTime);
        LocalDateTime localDateTime1 = DateTimeUtils.systemTimestampToLocalDateTime(System.currentTimeMillis());
        String format1 = localDateTime1.format(dateTimeFormatter);
        Date date2 = DateTimeUtils.localDateTimeToDate(localDateTime1);


        log.info("data {} ",  date);
        log.info("data1 {} ",  date1);
        log.info("data2 {} ",  date2);

        log.info("localDateTime: {} ",  format);
        log.info("localDateTime1: {} ",  format1);




        String s = "";
    }

    @Test
    public void systemTimestampToLocalDateTime() throws Exception {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        log.info("format: {}", format);

    }

    @Test
    public void localDateTimeToDate() throws Exception {
    }

}