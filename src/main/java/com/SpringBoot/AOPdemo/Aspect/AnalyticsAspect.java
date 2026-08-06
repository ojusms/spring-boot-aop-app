package com.SpringBoot.AOPdemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AnalyticsAspect {
    @Before("com.SpringBoot.AOPdemo.Utility.aopExpressions.forDAOnoGetterSetter()")
    public void performAnalytics() {
        System.out.println("==========> Performing analytics! <==========");
    }
}
