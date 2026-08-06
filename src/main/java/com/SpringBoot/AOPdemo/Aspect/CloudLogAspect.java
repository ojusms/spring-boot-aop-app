package com.SpringBoot.AOPdemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class CloudLogAspect {
    @Before("com.SpringBoot.AOPdemo.Utility.aopExpressions.forDAOnoGetterSetter()")
    public void performCloudLog() {
        System.out.println("==========> Saving Logs to Cloud! <==========");
    }
}
