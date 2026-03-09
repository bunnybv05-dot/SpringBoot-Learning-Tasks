package com.example.optional.service;

import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailNotificationService implements NotificationService {

    @Override
    public String sendNotification(String recipient, String message) {
        return "📧 EMAIL sent to " + recipient + ": " + message;
    }

    @Override
    public String getServiceType() {
        return "Email Service";
    }
}