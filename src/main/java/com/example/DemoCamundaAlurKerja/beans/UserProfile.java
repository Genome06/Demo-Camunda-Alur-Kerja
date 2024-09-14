package com.example.DemoCamundaAlurKerja.beans;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.identity.User;
import org.springframework.stereotype.Component;

@Component("userProfile")
public class UserProfile {
    public String getFullName(DelegateExecution delegateExecution, String userId){

        User user = delegateExecution.getProcessEngineServices().getIdentityService().createUserQuery().userId(userId).singleResult();
        return user.getFirstName() + " " + user.getLastName();
    }
    public String getFullName(String userId){
        ProcessEngine processEngine = this.getDefaultProcessEngine();
        User user = processEngine.getIdentityService().createUserQuery().userId(userId).singleResult();
        return user.getFirstName() + " " + user.getLastName();
    }

    ProcessEngine getDefaultProcessEngine() {
        return ProcessEngines.getDefaultProcessEngine();
    }
}
