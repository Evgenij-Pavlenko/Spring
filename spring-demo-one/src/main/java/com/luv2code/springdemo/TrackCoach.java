package com.luv2code.springdemo;

import org.springframework.beans.factory.DisposableBean;

public class TrackCoach implements Coach, DisposableBean {

    private FortuneService fortuneService;
    public TrackCoach() {
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it: " + fortuneService.getFortune();
    }

    //add an init method
    private void doInit(){
        System.out.println("TrackCoach: inside method doInit");
    }

    //add a destroy method
    public void destroy(){
        System.out.println("TrackCoach: inside method doDestroy");
    }
}
