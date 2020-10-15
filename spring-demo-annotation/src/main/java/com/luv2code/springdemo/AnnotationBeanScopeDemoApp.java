package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {

        //load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach otherCoach = context.getBean("tennisCoach", Coach.class);

        //check if they are same
        boolean res = (theCoach == otherCoach);

        //print out the res
        System.out.println("Pointing to the same object: " + res);

        System.out.println("Memory location for theCoach: "+theCoach);
        System.out.println("Memory location for otherCoach: "+otherCoach);

        //close the context
        context.close();
    }
}
