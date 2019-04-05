package com.weweibuy.webuy.common.utils;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @ClassName CodeUtils
 * @Description
 * @Author durenhao
 * @Date 2019/1/19 22:18
 **/
public class CodeUtils {

    public static String getSmsCode(Integer length){
        return RandomStringUtils.randomNumeric(length);
    }

}
