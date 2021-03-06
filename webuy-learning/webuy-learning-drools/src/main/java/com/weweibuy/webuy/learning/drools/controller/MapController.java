package com.weweibuy.webuy.learning.drools.controller;

import com.weweibuy.webuy.learning.drools.model.tax.TaxVO;
import lombok.RequiredArgsConstructor;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author durenhao
 * @date 2020/11/6 21:51
 **/
@RestController
@RequestMapping("/map")
@RequiredArgsConstructor
public class MapController {

    private final KieBase kieBase;


    @GetMapping
    public Map<Object, Object> taxVO(Integer age, Integer income, String date) {
        KieSession kieSession = kieBase.newKieSession();
        HashMap<Object, Object> hashMap = new HashMap<>();
        TaxVO taxVO = new TaxVO();
        if (income != null) {
            taxVO.setIncome(BigDecimal.valueOf(income));
        }
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("income", income);
        hashMap.put("age", age + "");
        hashMap.put("tax", new HashMap<>());
        hashMap.put("map", new HashMap<>());
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        hashMap.put("list", arrayList);
        kieSession.insert(hashMap);
        kieSession.fireAllRules();
        kieSession.dispose();
        return hashMap;
    }

}
