package com.example.di.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String getGreeting(String name) {
        String timeOfDay = getTimeOfDay();
        return String.format("Good %s, %s! Welcome to our application.", timeOfDay, name);
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to the Dependency Injection Demo Application!";
    }

    private String getTimeOfDay() {
        int hour = LocalDateTime.now().getHour();
        if (hour < 12) return "Morning";
        else if (hour < 17) return "Afternoon";
        else return "Evening";
    }
}