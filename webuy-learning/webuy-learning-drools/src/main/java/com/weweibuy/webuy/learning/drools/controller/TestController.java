package com.weweibuy.webuy.learning.drools.controller;

import com.weweibuy.webuy.learning.drools.model.CompareVO;
import com.weweibuy.webuy.learning.drools.model.Order;
import com.weweibuy.webuy.learning.drools.model.User;
import lombok.RequiredArgsConstructor;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2020/10/26 21:42
 **/
@RestController
@RequiredArgsConstructor
public class TestController {

    private final KieBase kieBase;

    @GetMapping("/order")
    public Order order(Order order) {
        KieSession kieSession = kieBase.newKieSession();
        kieSession.insert(order);
        kieSession.fireAllRules();
        kieSession.dispose();
        return order;
    }

    @GetMapping("/compare")
    public CompareVO compare(CompareVO compareVO) {
        KieSession kieSession = kieBase.newKieSession();
        kieSession.insert(compareVO);
        RuleNameEqualsAgendaFilter filter = new RuleNameEqualsAgendaFilter("test_2");
        kieSession.fireAllRules(filter);
        kieSession.dispose();
        return compareVO;
    }


    @GetMapping("/update")
    public User compare(User user) {
        KieSession kieSession = kieBase.newKieSession();
        kieSession.insert(user);
        kieSession.fireAllRules();
        kieSession.dispose();
        return user;
    }

}
