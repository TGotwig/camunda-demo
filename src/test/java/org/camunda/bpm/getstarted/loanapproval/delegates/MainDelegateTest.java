package org.camunda.bpm.getstarted.loanapproval.delegates;

import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.assertions.bpmn.ProcessInstanceAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.assertThat;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.complete;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.task;

@SpringBootTest
class MainDelegateTest {

    @Autowired private RuntimeService runtimeService;

    @Autowired private ManagementService managementService;

    ProcessInstance pi;

    @BeforeEach
    public void beforeEach() {
        pi = runtimeService.startProcessInstanceByKey("loanApproval");
        assertThat(pi).hasPassed("StartEvent_1").hasNotPassed("Task_0dfv74n").isNotEnded();
    }

    @Test
    public void happyPath() {
        completeTask().hasPassed("Task_0dfv74n").isEnded();
    }

    private ProcessInstanceAssert completeTask() {
        complete(task());
        return assertThat(pi);
    }
}