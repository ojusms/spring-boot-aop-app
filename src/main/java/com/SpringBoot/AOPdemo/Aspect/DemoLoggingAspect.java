package com.SpringBoot.AOPdemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// annotated with @Component to enable detection for component scanning
// annotated with @Aspect to let Spring know this class is an Aspect
@Component
@Aspect
public class DemoLoggingAspect {

    // all related advices for logging are added here. Starting with an @Before advice.

    // annotated with @Before since this advice executes before execution of target object addAccount() in the
    // pointcut expression. The method name can be anything of choice.
    // using a fully qualified classname now (package + [class/interface] in pointcut expression to match only that
    @Before("execution(public void com.SpringBoot.AOPdemo.DAO.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("==========> Executing @Before advice on addAccount() <==========");
    }
}
