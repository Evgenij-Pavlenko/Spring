package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

    // this is where we add all of our related advices for loggin

    // let's start with an @Before advice

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Before("forDaoPackage()")
//    @Before("execution(public void updateAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("====>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytic(){
        System.out.println("====>>> Performing API analytics");

    }


}
