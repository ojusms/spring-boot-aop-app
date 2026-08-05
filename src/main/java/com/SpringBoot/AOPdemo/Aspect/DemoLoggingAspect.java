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
    // pointcut expression now matches any method starting with "add" and having one single parameter of type Account class,
    // specified by qualified name, in any class for any
    // return type [void, boolean, List<>, etc.] using wildcard
    // Access modifier removed (public).
    @Before("execution(* add*(com.SpringBoot.AOPdemo.Account))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========> Executing @Before advice on add*() <==========");
    }
}
