package com.weweibuy.common.utils;

import java.util.UUID;

public class IDUtil {

    /**
     * 生成一个当前时间+100以内随机数的id
     * @return  long 当前时间+100以内随机数的id
     */
    public static Long getLongID(){
        long timeMillis = System.currentTimeMillis();
        int x=(int)(Math.random()*100);
        String str = timeMillis + String.valueOf(x);
        return Long.parseLong(str);
    }

    /**
     *  生成String类型 没有 “-” 的 UUID
     * @return String UUID
     */
    public static String getStringUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取一个UUID+时间戳的 消息ID；用作消息的deliverTag
     * @return  String  UUID+时间
     */
    public static String getRandomMessage(){
        return getStringUUID() + "-" + System.currentTimeMillis();
    }

}
