package com.weweibuy.webuy.learning.drools.controller;

import com.weweibuy.webuy.learning.drools.model.CalculateVO;
import com.weweibuy.webuy.learning.drools.model.CompareVO;
import com.weweibuy.webuy.learning.drools.model.Order;
import com.weweibuy.webuy.learning.drools.model.User;
import com.weweibuy.webuy.learning.drools.service.UserService;
import lombok.RequiredArgsConstructor;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.QueryResults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author durenhao
 * @date 2020/10/26 21:42
 **/
@RestController
@RequiredArgsConstructor
public class TestController {

    private final KieBase kieBase;

    private final UserService userService;

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
//        kieSession.fireAllRules(filter);
        kieSession.fireAllRules();
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

    @GetMapping("/agenda_group")
    public User agendaGroup(User user) {
        KieSession kieSession = kieBase.newKieSession();
        // 只对agenda-group 的规则匹配
        kieSession.getAgenda().getAgendaGroup("a2").setFocus();
        kieSession.insert(user);
        kieSession.fireAllRules();
        kieSession.dispose();
        return user;
    }

    @GetMapping("/timer")
    public User timer(User user) throws InterruptedException {
        KieSession kieSession = kieBase.newKieSession();
        // 只对agenda-group 的规则匹配
        new Thread(() -> kieSession.fireUntilHalt())
                .start();
        Thread.sleep(10000);
        kieSession.halt();
        kieSession.dispose();
        return user;
    }


    @GetMapping("/date")
    public User date(User user) {
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");
        KieSession kieSession = kieBase.newKieSession();
        // 只对agenda-group 的规则匹配
        kieSession.insert(user);
        kieSession.fireAllRules();
        kieSession.dispose();
        return user;
    }


    @GetMapping("/global")
    public User global(User user) {
        KieSession kieSession = kieBase.newKieSession();
        // 只对agenda-group 的规则匹配
        kieSession.setGlobal("count", 10);
        kieSession.setGlobal("list", new ArrayList<String>());
        kieSession.setGlobal("userService", userService);
        kieSession.insert(user);
        kieSession.fireAllRules();
        kieSession.dispose();
        return user;
    }

    @GetMapping("/query")
    public User query(User user) {
        KieSession kieSession = kieBase.newKieSession();
        // 只对agenda-group 的规则匹配
        kieSession.setGlobal("count", 10);
        kieSession.setGlobal("list", new ArrayList<String>());
        kieSession.setGlobal("userService", userService);
        kieSession.insert(user);
        QueryResults query_test = kieSession.getQueryResults("query_test");
        QueryResults query_test2 = kieSession.getQueryResults("query_test2", "tom");
        int size = query_test.size();
        int size1 = query_test2.size();
        System.err.println("查询query_test结果条数: " + size);
        System.err.println("查询query_test2结果条数: " + size1);
        kieSession.fireAllRules();
        kieSession.dispose();
        return user;
    }

    @PostMapping("/calculate")
    public String calculate(@RequestBody CalculateVO c) {
        KieSession kieSession = kieBase.newKieSession();
        AgendaFilter filter = new RuleNameStartsWithAgendaFilter("calculate_big");
//        kieSession.fireAllRules(filter);
        kieSession.insert(c);
        kieSession.fireAllRules(filter);
        kieSession.dispose();
        return "xx";
    }

}
