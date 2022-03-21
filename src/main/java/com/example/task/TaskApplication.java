package com.example.task;

import com.example.task.example.AbstractTaskTriggerHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) {
        AbstractTaskTriggerHandler.initTaskHandler();
        SpringApplication.run(TaskApplication.class, args);
    }

}
