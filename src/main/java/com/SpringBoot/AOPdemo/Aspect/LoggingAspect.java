package com.SpringBoot.AOPdemo.Aspect;

import com.SpringBoot.AOPdemo.Account;
import com.SpringBoot.AOPdemo.DAO.AccountDAO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

// annotated with @Component to enable detection for component scanning
// annotated with @Aspect to let Spring know this class is an Aspect
// annotated with @Order to indicate the order of applying Aspects to Spring. Otherwise, no fixed order.
// Lower number has higher precedence. Numbers do not have to be contiguous. -ve numbers can also be used.
@Component
@Aspect
@Order(1)
public class LoggingAspect {

    // add a new method for @AfterThrowing advice. This is called only if the findAccounts()
    // method throws an exception. Here 'throwing' field consists of the exception thrown.
    // The value is bound to the Throwable parameter in the method. Same as for the 'returning' field prior,
    // the names have to be the same so it can bind.
    @AfterThrowing(pointcut = "execution(* com.SpringBoot.AOPdemo.DAO.AccountDAO.findAccounts(..))",
            throwing = "exc")
    void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        // print out which method advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n==========>Executing @AfterThrowing advice on method: "+method+ " <==========");
        // print out result of method call
        System.out.println("==========> Exception is: "+ exc);

    }

    // add a new method for @AfterReturning advice. Here returning field contains the
    // value returned by the findAccounts() method. The name can be anything but must be consistent with the parameter
    // used in the method signature below. i.e both are "result"
    @AfterReturning(pointcut = "execution(* com.SpringBoot.AOPdemo.DAO.AccountDAO.findAccounts(..))",
            returning = "result")
    void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        // print out which method advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n==========>Executing @AfterReturning advice on method: "+method+ " <==========");
        // print out result of method call
        System.out.println("==========> result is: "+result);
        // perform some post-processing
        convertAccountNamesToUpperCase(result);
        // print out the modified result
        System.out.println("==========> post-processed result is: "+result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        //iterate over list of accounts
        for (Account tempAccount : result) {
            // set each account name to be the uppercase version of itself
            tempAccount.setName(tempAccount.getName().toUpperCase());
        }
    }

    // all related advices for logging are added here. Starting with an @Before advice.
    // have to use fully qualified name since Pointcut Declarative exists in a separate file now
    @Before("com.SpringBoot.AOPdemo.Utility.aopExpressions.forDAOnoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n==========> Executing @Before advice on any method() <==========");
        // JoinPoint contains metadata about method call
        // Display method signature using JoinPoint
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature(); // casting Signature to MethodSig..
        System.out.println("Signature: "+methodSignature);

        // retrieve and print method arguments
        Object[] args = joinPoint.getArgs();
        for (Object tempObj : args)
        {
            System.out.println(tempObj);
            // casting argument obj of type Account to Account obj for better print statement. Prints raw hash otherwise.
            // Alternatively, Account.toString() can be overridden
            if (tempObj instanceof Account) {
                Account a = (Account) tempObj;
                System.out.println("Account name: "+a.getName());
                System.out.println("Account level: "+a.getLevel());
            }
        }
    }
}

