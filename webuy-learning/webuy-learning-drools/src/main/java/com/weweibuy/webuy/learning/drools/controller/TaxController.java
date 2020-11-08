package com.weweibuy.webuy.learning.drools.controller;

import com.weweibuy.webuy.learning.drools.model.tax.TaxVO;
import lombok.RequiredArgsConstructor;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author durenhao
 * @date 2020/11/6 21:51
 **/
@RestController
@RequestMapping("/tax")
@RequiredArgsConstructor
public class TaxController {

    private final KieBase kieBase;


    @GetMapping
    public TaxVO taxVO(String amount) {
        KieSession kieSession = kieBase.newKieSession();
        TaxVO taxVO = new TaxVO();
        taxVO.setIncome(new BigDecimal(amount));
        kieSession.insert(taxVO);
        kieSession.fireAllRules();
        kieSession.dispose();
        return taxVO;
    }

}
