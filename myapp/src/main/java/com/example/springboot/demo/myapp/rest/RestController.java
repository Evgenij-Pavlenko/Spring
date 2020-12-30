package com.example.springboot.demo.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    // expose "/" that return "Hello World"

    @GetMapping("/")
    public String sayHello(){
        return "Hello World. Time on server is: " + LocalDateTime.now();
    }
}
