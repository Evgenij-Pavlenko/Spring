package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {

        //read spring config java file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);
        //get the bean from spring container
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
//        Coach veloCoach = context.getBean("veloCoach", Coach.class);
        //call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
//        System.out.println(veloCoach.getDailyWorkout());
        //call method to get the daily fortune
        System.out.println(theCoach.getDailyFortune());

        //call ournew swim coach method ... has the props values injected
        System.out.println("email: " + theCoach.getEmail());
        System.out.println("team: " + theCoach.getTeam());
        //close the context
        context.close();
    }
}
