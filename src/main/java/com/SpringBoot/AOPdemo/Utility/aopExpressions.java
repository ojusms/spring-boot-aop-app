package com.SpringBoot.AOPdemo.Utility;

// utility class to make Pointcut Declaratives/expressions accessible to Aspects and their Advices
// changing access modifier to Public from Private for accessibility

import org.aspectj.lang.annotation.Pointcut;

public class aopExpressions {
    // pointcut expression now matches any methods inside any classes under DAO package,
    // having 0 or more parameters of any type, for any return type [void, boolean, List<>, etc.] using wildcard
    // Access modifier removed (public).
    // Below is a Pointcut Declarative. It is a way to set the pointcut expression as a variable that can be used for
    // multiple Advice methods. The method name can be anything and acts as the variable name to be used, as seen below.

    @Pointcut("execution(* com.SpringBoot.AOPdemo.DAO.*.*(..))")
    public void forDAO() {}

    // new pointcut declarative for getter methods inside any classes inside DAO package
    // expression states methods starting with 'get' inside classes within DAO package, similar for 'set' below
    @Pointcut("execution(* com.SpringBoot.AOPdemo.DAO.*.get*(..))")
    public void getter() {}
    // new pointcut declarative for setter methods inside any classes inside DAO package
    @Pointcut("execution(* com.SpringBoot.AOPdemo.DAO.*.set*(..))")
    public void setter() {}

    // pointcut declarative combining other declaratives/expressions using logical operators (&&, ||, !)
    // expressions states all methods inside all classes within DAO package excluding those starting with 'get' and 'set'
    @Pointcut("forDAO() && !(getter() || setter())")
    public void forDAOnoGetterSetter() {}
}

/*
    For understanding parameter matching of method in pointcut expression -
    method() - no parameters
    method(*) - only 1 parameter of specific type, here * is replaced by actual value
    method(..) - 0 or more parameters of any type
 */
