package com.weweibuy.webuy.learning.activity.controller;

import com.weweibuy.webuy.learning.activity.service.ActivityService;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2020/7/13 10:39
 **/
@RestController
@RequestMapping("/activity")
public class ActivityController {


    private final TaskRuntime taskRuntime;

    private final ProcessRuntime processRuntime;

    private final ActivityService activityService;

    private final RuntimeService runtimeService;

    private final TaskService taskService;


    public ActivityController(TaskRuntime taskRuntime, ProcessRuntime processRuntime,
                              ActivityService activityService, RuntimeService runtimeService, TaskService taskService) {
        this.taskRuntime = taskRuntime;
        this.processRuntime = processRuntime;
        this.activityService = activityService;
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }


    @RequestMapping("/start")
    public void start(String userName, Integer num, Long id) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceBuilder()
                .businessKey(id + "")
                .processDefinitionKey("myProcess_1")
                .start();
    }

    /**
     * 代办查询
     *
     * @param userName
     * @return
     */
    @GetMapping("/duty")
    public Object duty(String userName) {
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("myProcess_1")
                .taskCandidateUser(userName)
                .list();
        return taskList.stream()
                .map(Task::getBusinessKey)
                .collect(Collectors.toList());
    }

    /**
     * 在办
     *
     * @param userName
     * @return
     */
    @GetMapping("/on-duty")
    public Object onDuty(String userName) {
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("myProcess_1")
                .taskCandidateOrAssigned(userName)
                .list();
        return taskList.stream()
                .map(Task::getBusinessKey)
                .collect(Collectors.toList());
    }


    /**
     * 领单
     *
     * @param userName
     * @return
     */
    @GetMapping("/duty-take")
    public Object takeDuty(String userName) {
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("myProcess_1")
                .taskCandidateUser(userName)
                .list();
        Task task = null;
        if (CollectionUtils.isNotEmpty(taskList)) {
            task = taskList.get(0);
            String id = task.getId();
            taskService.claim(id, userName);
        }
        return task.getId();
    }

    @GetMapping("/duty-complete")
    public Object dutyComplete(String userName) {
        List<Task> task = activityService.findTask(userName);
        Task task1 = null;
        if (CollectionUtils.isNotEmpty(task)) {
            task1 = task.get(0);
            activityService.completeTask(userName, task1.getId(), 1);
        }
        return task1.getId();
    }

}
