package com.tutorial.softwarepractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SoftwarePracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftwarePracticeApplication.class, args);
    }

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

}
