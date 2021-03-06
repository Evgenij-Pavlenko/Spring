package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {
        // read spring config java class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDao = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the account
        List<Account> theAccounts = theAccountDao.findAccounts();

        // display the accounts
        System.out.println("\nMain Programm: AfterReturningDemoApp");
        System.out.println("------------");

        System.out.println(theAccounts);
        System.out.println("\n");

        // close the context
        context.close();
    }
}
