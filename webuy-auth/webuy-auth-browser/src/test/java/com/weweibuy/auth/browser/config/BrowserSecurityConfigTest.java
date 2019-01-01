package com.weweibuy.auth.browser.config;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class BrowserSecurityConfigTest {

    @Test
    public void test(){
        byte[] tokenByte = Base64.encodeBase64(("webuy"+":"+"webuy123").getBytes());
        String s = new String(tokenByte);
        System.err.println(s);

    }


}