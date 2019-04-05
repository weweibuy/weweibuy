package com.weweibuy.webuy.user.service.impl;

import com.weweibuy.webuy.user.common.eum.UserWebMsgEum;
import org.junit.Test;

public class UserServiceImplTest {

    @Test
    public void test01(){
        UserWebMsgEum unknown_wrong = UserWebMsgEum.valueOf("UNKNOWN_WRONG");
        String msg = unknown_wrong.getMsg();
        System.err.println(msg);

    }

}