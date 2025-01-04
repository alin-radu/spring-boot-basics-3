package com.dev.spring_core_demo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "BaseballCoach, spend 30min in batting practice!";
    }
}
