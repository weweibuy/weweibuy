package com.weweibuy.webuy.learning.activity.controller;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author durenhao
 * @date 2020/7/13 15:43
 **/
@RestController
@RequestMapping("/activity")
public class ActivityHiController {


    private final HistoryService historyService;

    public ActivityHiController(HistoryService historyService) {
        this.historyService = historyService;
    }


    @GetMapping("/hi")
    public Object queryHi() {

        List<HistoricActivityInstance> userTask = historyService.createHistoricActivityInstanceQuery()
                .activityType("userTask")
                .list();

       return historyService.createHistoricTaskInstanceQuery()
                .processDefinitionKey("myProcess_1")
                .list();

    }


}
