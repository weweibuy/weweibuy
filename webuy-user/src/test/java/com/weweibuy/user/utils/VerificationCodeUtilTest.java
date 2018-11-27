package com.weweibuy.user.utils;

import org.junit.Test;

public class VerificationCodeUtilTest {

    @Test
    public void sendVerificationCode() throws Exception {
        VerificationCodeUtil.sendVerificationCode("1232144");
    }

}