package com.sharma.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Car {

    @Autowired
    public Engine engine;
    @GetMapping("/hello")
    public String ok(){
        return engine.name();
    }
}
