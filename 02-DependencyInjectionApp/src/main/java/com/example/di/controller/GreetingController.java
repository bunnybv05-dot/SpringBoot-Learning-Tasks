package com.example.di.controller;

import com.example.di.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/personal/{name}")
    public String getPersonalGreeting(@PathVariable String name) {
        return greetingService.getGreeting(name);
    }

    @GetMapping("/welcome")
    public String getWelcomeGreeting(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        return "Hello " + name + "! " + greetingService.getWelcomeMessage();
    }

    @GetMapping("/message")
    public String getSimpleMessage() {
        return greetingService.getWelcomeMessage();
    }
}