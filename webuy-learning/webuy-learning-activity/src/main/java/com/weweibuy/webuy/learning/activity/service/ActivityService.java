package com.weweibuy.webuy.learning.activity.service;

import com.weweibuy.webuy.learning.activity.model.leaveInfo;
import lombok.extern.slf4j.Slf4j;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author durenhao
 * @date 2020/7/13 10:43
 **/
@Slf4j
@Service
public class ActivityService {

    private final TaskRuntime taskRuntime;

    private final ProcessRuntime processRuntime;

    private final RuntimeService runtimeService;

    private final TaskService taskService;

    public ActivityService(TaskRuntime taskRuntime, ProcessRuntime processRuntime, RuntimeService runtimeService, TaskService taskService) {
        this.taskRuntime = taskRuntime;
        this.processRuntime = processRuntime;
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }


    public void startProcesses(Long id, Integer num, String userName) {
        leaveInfo leaveInfo = new leaveInfo();
        leaveInfo.setUserName(userName);
        leaveInfo.setNum(num);
        ProcessInstance processInstance = runtimeService.createProcessInstanceBuilder()
                .businessKey(id + "")
                .processDefinitionKey("myProcess_1")
                .variable("leaveInfo", leaveInfo)
                .start();
    }

    public void changeStatus(DelegateExecution execution, Integer status) {
        log.info("修改请假单状态为: {}", status);
        String processInstanceBusinessKey = execution.getProcessInstanceBusinessKey();
        log.info("修改请假单: {}, 状态为: {}", processInstanceBusinessKey, status);
    }


    public List<String> findPm(DelegateExecution execution) {
        return Arrays.asList("tom", "luck");
    }

    public List<String> findHr(DelegateExecution execution) {
        return Arrays.asList("jack", "json");
    }


    public List<Task> findTask(String userName) {
        return taskService.createTaskQuery()
                .processDefinitionKey("myProcess_1")
                .taskCandidateOrAssigned(userName)
                .list();
    }


    public void completeTask(String userName, String taskId, Integer status) {
        taskService.claim(taskId, userName);
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("status", status);
        taskService.complete(taskId, hashMap);
    }


}
