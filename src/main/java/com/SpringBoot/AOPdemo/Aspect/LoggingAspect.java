package com.SpringBoot.AOPdemo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// annotated with @Component to enable detection for component scanning
// annotated with @Aspect to let Spring know this class is an Aspect
// annotated with @Order to indicate the order of applying Aspects to Spring. Otherwise, no fixed order.
// Lower number has higher precedence. Numbers do not have to be contiguous. -ve numbers can also be used.
@Component
@Aspect
@Order(1)
public class LoggingAspect {

    // all related advices for logging are added here. Starting with an @Before advice.
    // have to use fully qualified name since Pointcut Declarative exists in a separate file now
    @Before("com.SpringBoot.AOPdemo.Utility.aopExpressions.forDAOnoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n==========> Executing @Before advice on any method() <==========");
        // JoinPoint contains metadata about method call
        // Display method signature using JoinPoint
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature(); // casting Signature to MethodSig..
        System.out.println("Signature: "+methodSignature);
    }
}

