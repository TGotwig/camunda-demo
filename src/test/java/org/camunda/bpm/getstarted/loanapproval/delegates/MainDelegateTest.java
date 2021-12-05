package org.camunda.bpm.getstarted.loanapproval.delegates;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.assertThat;

@SpringBootTest
class MainDelegateTest {

    @Autowired private RuntimeService runtimeService;

    @Test
    public void happyPath() {
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("loanApproval");
        assertThat(pi).hasPassed("StartEvent_1").hasNotPassed("Task_0dfv74n");
    }
}