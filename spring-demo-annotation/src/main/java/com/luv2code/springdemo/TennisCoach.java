package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    //define a field - @Autowired
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
    }
//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }


    //define a setter method - @Autowired
//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }


    //define a some method - @Autowired
//    @Autowired
//    public void doSomeCrazyStuff(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice you backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
