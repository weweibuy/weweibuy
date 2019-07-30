package com.weweibuy.webuy.user.service.impl;

import com.weweibuy.webuy.user.common.eum.UserWebMsgEum;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class UserServiceImplTest {

    @Test
    public void test01(){
        UserWebMsgEum unknown_wrong = UserWebMsgEum.valueOf("UNKNOWN_WRONG");
        String msg = unknown_wrong.getMsg();
        System.err.println(msg);

    }


    @Test
    public void test02(){

        ArrayList<String> objects = new ArrayList<>();
        objects.add("121");
        System.err.println(objects.toString());
    }


    @Test
    public void test03(){
        String s = "121212";
        String str = "abc;1213;QWE";
        int i = str.indexOf(";");
        String[] split = StringUtils.split(s, ";", 2);
        System.err.println(Arrays.asList(split));
        System.err.println(split.length);


    }

}