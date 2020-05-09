package com.tutorial.softwarepractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tutorial.softwarepractice.service", "com.tutorial.softwarepractice.controller"})
public class SoftwarePracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftwarePracticeApplication.class, args);
    }

}
