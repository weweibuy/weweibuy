package com.weweibuy.webuy.learning.sharing.utils;

import com.baidu.fsg.uid.UidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author durenhao
 * @date 2019/8/2 23:03
 **/
@Component
public class UIdHelper {

    private static UidGenerator generator;

    @Autowired
    private UidGenerator uidGenerator;

    @PostConstruct
    public void init() {
        generator = uidGenerator;
    }

    public static Long nextId() {
        return generator.getUID();
    }

    public static String nextStrId() {
        return generator.getUID() + "";
    }

}
