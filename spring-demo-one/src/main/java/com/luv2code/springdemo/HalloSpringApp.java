package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HalloSpringApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);
        String dailyWorkout = theCoach.getDailyWorkout();
        String dailyFortune = theCoach.getDailyFortune();

        System.out.println(dailyWorkout);
        System.out.println(dailyFortune);
        context.close();
    }
}
