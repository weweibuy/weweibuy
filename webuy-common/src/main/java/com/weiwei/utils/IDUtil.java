package com.weiwei.utils;

public class IDUtil {

    public static Long getLongID(){
        long timeMillis = System.currentTimeMillis();
        int x=(int)(Math.random()*100);
        String str = timeMillis + String.valueOf(x);
        Long l = Long.parseLong(str);
        return l;
    }
}
