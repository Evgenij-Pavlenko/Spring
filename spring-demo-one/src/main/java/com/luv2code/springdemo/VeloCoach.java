package com.luv2code.springdemo;

public class VeloCoach implements Coach{

    private FortuneService fortuneService;

    public VeloCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Ride a bike 1 hour";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
