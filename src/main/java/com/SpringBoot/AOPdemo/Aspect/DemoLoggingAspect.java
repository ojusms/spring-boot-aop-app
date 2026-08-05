package com.SpringBoot.AOPdemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// annotated with @Component to enable detection for component scanning
// annotated with @Aspect to let Spring know this class is an Aspect
@Component
@Aspect
public class DemoLoggingAspect {

    // all related advices for logging are added here. Starting with an @Before advice.

    // annotated with @Before since this advice executes before execution of target object addAccount() in the
    // pointcut expression. The method name can be anything of choice.
    // pointcut expression now matches any methods inside any classes under DAO package,
    // having 0 or more parameters of any type, for any return type [void, boolean, List<>, etc.] using wildcard
    // Access modifier removed (public).
    // Below is a Pointcut Declarative. It is a way to set the pointcut expression as a variable that can be used for
    // multiple Advice methods. The method name can be anything and acts as the variable name to be used, as seen below.

    @Pointcut("execution(* com.SpringBoot.AOPdemo.DAO.*.*(..))")
    private void forDAO() {}

    @Before("forDAO()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========> Executing @Before advice on any method() <==========");
    }

    // new Advice to demonstrate reusability of pointcut expression via pointcut declarative.
    @Before("forDAO()")
    public void performAnalytics() {
        System.out.println("==========> Performing analytics! <==========");
    }
}

/*
    For understanding parameter matching of method in pointcut expression -
    method() - no parameters
    method(*) - only 1 parameter of specific type, here * is replaced by actual value
    method(..) - 0 or more parameters of any type
 */