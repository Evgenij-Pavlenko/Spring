package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

    private String[] fortuneServices = {
            "Today is your lucky day!",
            "Today is normal day!",
            "Today is bad day(("
    };

    @Override
    public String getFortune() {
        Random rand = new Random();
        int r = rand.nextInt(fortuneServices.length);
        System.out.println("Random: " + r);
        System.out.println(fortuneServices[r]);
        return fortuneServices[r];
    }
}
