package com.weweibuy.webuy.support.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @ClassName CodeUtils
 * @Description
 * @Author durenhao
 * @Date 2019/1/19 22:18
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CodeUtils {

    public static String getSmsCode(Integer length){
        return RandomStringUtils.randomNumeric(length);
    }

}
