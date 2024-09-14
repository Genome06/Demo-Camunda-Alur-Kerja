package com.example.DemoCamundaAlurKerja.beans;

import org.camunda.bpm.engine.impl.pvm.delegate.ActivityExecution;

public class BaseCustomCamundaBean {

    protected ActivityExecution execution;


    public BaseCustomCamundaBean setExecution(ActivityExecution execution) {
        this.execution = execution;
        return  this;
    }

    public String getStringVariable(String variableName) {
        return (String) execution.getVariable(variableName);
    }


}
