package com.luv2code.springdemo;

public class MyApp {
    public static void main(String[] args) {

//        Coach theCoach = new BaseballCoach();
        Coach theCoach = new TrackCoach();

        String dailyWorkout = theCoach.getDailyWorkout();

        System.out.println(dailyWorkout);
    }
}
