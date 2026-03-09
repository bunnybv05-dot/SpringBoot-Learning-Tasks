package com.example.qualifier.controller;

import com.example.qualifier.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService emailService;
    private final NotificationService smsService;
    
    // Constructor Injection with @Qualifier
    @Autowired
    public NotificationController(
            @Qualifier("emailService") NotificationService emailService,
            @Qualifier("smsService") NotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
        System.out.println("✅ Controller initialized with both services");
    }
    
    // Endpoint 1: Send Email
    @PostMapping("/email")
    public String sendEmail(
            @RequestParam String to,
            @RequestParam String message) {
        return emailService.sendNotification(to, message);
    }
    
    // Endpoint 2: Send SMS
    @PostMapping("/sms")
    public String sendSMS(
            @RequestParam String to,
            @RequestParam String message) {
        return smsService.sendNotification(to, message);
    }
    
    // Endpoint 3: Get Email Service Info
    @GetMapping("/email/info")
    public String getEmailInfo() {
        return emailService.getServiceType();
    }
    
    // Endpoint 4: Get SMS Service Info
    @GetMapping("/sms/info")
    public String getSmsInfo() {
        return smsService.getServiceType();
    }
    
    // Endpoint 5: Dynamic selection
    @PostMapping("/send/{type}")
    public String sendNotification(
            @PathVariable String type,
            @RequestParam String to,
            @RequestParam String message) {
        
        if ("email".equalsIgnoreCase(type)) {
            return emailService.sendNotification(to, message);
        } else if ("sms".equalsIgnoreCase(type)) {
            return smsService.sendNotification(to, message);
        } else {
            return "❌ Invalid type. Use 'email' or 'sms'";
        }
    }
}