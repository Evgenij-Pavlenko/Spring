package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

    // this is where we add all of our related advices for loggin

    // let's start with an @Before advice
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("====>>> Executing @Before advice on addAccount()");
    }
}
