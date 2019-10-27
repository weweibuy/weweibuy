package com.weweibuy.webuy.learning.event.event.parser;

import java.util.concurrent.TimeUnit;

/**
 * @author durenhao
 * @date 2019/10/27 20:50
 **/
public class EventRuleParser {


    public static Long parse(String rule, Long time, Integer count) {
        String[] split = rule.split(" ");
        String current = null;
        if (count > split.length) {
            current = split[split.length - 1];
        } else if (count <= 0) {
            current = split[0];
        } else {
            current = split[count - 1];
        }

        if (current.toLowerCase().equals("end")) {
            return -1L;
        }

        if (current.equals("...")) {
            current = split[split.length - 2];
        }

        String timeStr = current.substring(0, current.length() - 1);
        String unit = current.substring(current.length() - 1, current.length());

        TimeUnit timeUnit = null;
        if (unit.toLowerCase().endsWith("s")) {
            timeUnit = TimeUnit.SECONDS;
        } else if (unit.toLowerCase().endsWith("m")) {
            timeUnit = TimeUnit.MINUTES;
        } else if (unit.toLowerCase().endsWith("h")) {
            timeUnit = TimeUnit.HOURS;
        } else if (unit.toLowerCase().endsWith("d")) {
            timeUnit = TimeUnit.DAYS;
        }
        long l = timeUnit.toMillis(Integer.valueOf(timeStr));
        return time + l;
    }


}
