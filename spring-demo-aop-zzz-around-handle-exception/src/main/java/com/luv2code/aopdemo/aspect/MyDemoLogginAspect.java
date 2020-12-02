package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundWithLoggerDemoApp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {
    
    private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
    
    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;
        try{
            result = theProceedingJoinPoint.proceed();
        }catch (Exception ex){
            // log the exception
            myLogger.warning(ex.getMessage());
            // give user a custom message
            result = "Major accsident! But no worries, your private AOP helicopter is on the way!";
        }
        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        myLogger.info("\n=====>> Duration: " + duration / 1000 + " s");
        return result;
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(
            JoinPoint theJoinPoint) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @After (finally) on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theEx"
    )
    public void afterThrowingFindAccountAdvice(
            JoinPoint theJoinPoint, Throwable theEx) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @AfterThrowing on method: " + method);
        // log the exception
        myLogger.info("\n=====>>> exception is: " + theEx);


    }

    // add a new advice for @AfterReturning on the findAccount method
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountAdvice(
            JoinPoint theJoinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @AfterReturning on method: " + method);
        // print out the result of the method call
        myLogger.info("\n=====>>> result is: " + result);

        // let's post-process the data ... let's modify it :-)

        // convert the account names to uppercase
        convertAccounyNamesToUpperCase(result);
        myLogger.info("\n=====>>> result is: " + result);


    }

    private void convertAccounyNamesToUpperCase(List<Account> result) {

        // loop through accounts
        for (Account tempAccount : result) {

            // get uppercase version of name
            // update the name on the account
            tempAccount.setName(tempAccount.getName().toUpperCase());
        }
    }

    @Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        myLogger.info("\n====>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        myLogger.info("Method: " + methodSignature);
        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object tempArg : args) {

            if (tempArg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;
                myLogger.info("account name: " + theAccount.getName());
                myLogger.info("account level: " + theAccount.getLevel());
            } else myLogger.info(tempArg.toString());
        }
    }
}
