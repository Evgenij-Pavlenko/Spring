package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class VeloCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Ride a bike for 1 hour";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
