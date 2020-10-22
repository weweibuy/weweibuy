package com.weweibuy.webuy.learning.flowable.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.service.delegate.DelegateTask;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2020/10/22 22:43
 **/
@Slf4j
@Component("taskBusinessCallListener")
@RequiredArgsConstructor
public class TaskBusinessCallListener implements TaskListener {

    private final RuntimeService runtimeService;

    private final RepositoryService repositoryService;

    @Override
    public void notify(DelegateTask delegateTask) {


        String processInstanceId = delegateTask.getProcessInstanceId();
        String processDefinitionId = delegateTask.getProcessDefinitionId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId).singleResult();

        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionId(processDefinitionId).singleResult();

        // taskDefinitionKey 对应BPMN 的任务主键ID
        String taskDefinitionKey = delegateTask.getTaskDefinitionKey();
        String businessKey = processInstance.getBusinessKey();
        /*
         * 这个查出来是空的!!!
         * String processDefinitionKey = processInstance.getProcessDefinitionKey();
         */

        log.error("业务号: {}, 流程key: {}, 任务Key: {} 审批完成", businessKey, processDefinition.getKey(), taskDefinitionKey);
    }
}
