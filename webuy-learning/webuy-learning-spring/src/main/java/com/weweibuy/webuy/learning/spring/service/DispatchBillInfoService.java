package com.weweibuy.webuy.learning.spring.service;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.Executor;

/**
 * @author durenhao
 * @date 2019/8/1 21:54
 **/
@Service
public class DispatchBillInfoService implements InitializingBean{

    @Autowired
    private Executor executor;

    private Map<Integer, String> vendCustCodeMap = new HashedMap<>(16);

    private Map<Integer, String> vendCustNameMap = new HashedMap<>(16);


    public void batchInsert(){

    }


    @Override
    public void afterPropertiesSet() throws Exception {
        for(int i = 0; i < 50; i++){
            vendCustCodeMap.put(i, "vendcust_code_" + 1);
            vendCustNameMap.put(i, "vendcust_name_" + 1);
        }
    }
}
