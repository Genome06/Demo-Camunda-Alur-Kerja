package com.example.DemoCamundaAlurKerja.beans;

import com.example.DemoCamundaAlurKerja.utils.StringUtils;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component("utils")
public class Utils extends BaseCustomCamundaBean{

    public void checkVariable(){
        System.out.println("Checking variable");
        System.out.println(execution.getVariables());
    }

    public String generateRandomString(int length) {
        System.out.println("Generate random string");
        return StringUtils.genereateRandomString(length);
    }

    public String generateNumber(int length) {
        System.out.println("Generate number");
        return StringUtils.generateNumber(length);
    }

    public void setAllVAriableAsProcessVariable() {
        System.out.println("Setting all variable as process variable");
        execution.getVariables().forEach((key, value) -> {
            execution.setVariable(key, value);
        });
    }

    public String convertDateFormat(String date,  String format ,  String formatDest) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        SimpleDateFormat sdf2 = new SimpleDateFormat(formatDest);
        return sdf2.format(sdf.parse(date));
    }

}
