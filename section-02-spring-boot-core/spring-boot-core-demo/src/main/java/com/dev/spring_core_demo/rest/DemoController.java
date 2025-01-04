package com.dev.spring_core_demo.rest;

import com.dev.spring_core_demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daily-workout")
public class DemoController {

    private final Coach coach;

//    @Autowired
//    public DemoController(Coach coach) {
//        this.coach = coach;
//    }

    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach coach) {
        this.coach = coach;
    }

//    @Autowired
//    public void setCoach(Coach coach) {
//        this.coach = coach;
//    }

//    @Autowired
//    public void doSomePreparation(Coach coach) {
//        System.out.println("executed");
//        this.coach = coach;
//    }

    @GetMapping("")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
