package com.dev.spring_core_demo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "CricketCoach, practice fast bowling for 15 minutes!";
    }
}
