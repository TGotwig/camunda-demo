package org.camunda.bpm.getstarted.loanapproval.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
public class MainDelegate {

    public void validateTheRequest(DelegateExecution execution) {
        System.out.println("🚀 Executing MainDelegate.validateTheRequest");
    }
}
