package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        // read spring config java class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDao = context.getBean("accountDAO", AccountDAO.class);

        // get membership bean from spring container

        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method
        Account myAccount = new Account();
        theAccountDao.addAccount(myAccount, true);
        theAccountDao.doWork();


        // call the business method
        theMembershipDAO.addAccount();
        theMembershipDAO.goToSleep();

        // do it again!
//        System.out.println("\n let's call it again!");

        // call the business method again

//        theAccountDao.addAccount(3);
        // close the context
        context.close();
    }
}
