package com.SpringBoot.AOPdemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnalyticsAspect {
    @Before("com.SpringBoot.AOPdemo.Utility.aopExpressions.forDAOnoGetterSetter()")
    public void performAnalytics() {
        System.out.println("==========> Performing analytics! <==========");
    }
}
