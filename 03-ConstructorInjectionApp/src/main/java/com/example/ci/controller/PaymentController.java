package com.example.ci.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    
    @GetMapping("/test")
    public String test() {
        return "✅ PaymentController is working!";
    }
}