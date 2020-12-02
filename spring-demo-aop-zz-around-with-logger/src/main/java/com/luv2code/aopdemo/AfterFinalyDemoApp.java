package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinalyDemoApp {

    public static void main(String[] args) {
        // read spring config java class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDao = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the account
        List<Account> theAccounts = null;
        try {
            // add a boolean flag to simulate exceptions
            boolean tripWire = true;
            theAccounts = theAccountDao.findAccounts(tripWire);
        } catch (Exception ex) {
            System.out.println("\nMain Programm ... caught exception: " + ex);
        }

        // display the accounts
        System.out.println("\nMain Programm: AfterFinallyDemoApp");
        System.out.println("------------");

        System.out.println(theAccounts);
        System.out.println("\n");

        // close the context
        context.close();
    }
}
