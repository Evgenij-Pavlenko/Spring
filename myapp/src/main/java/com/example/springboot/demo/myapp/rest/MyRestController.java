package com.example.springboot.demo.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class MyRestController {
    // expose "/" that return "Hello World"

    @GetMapping("/")
    public String sayHello(){
        return "Hello World. Time on server is: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MMM-dd, HH:mm:ss"));
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }

    // add a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getFortune(){
        return "Lacky Day!";
    }

}
