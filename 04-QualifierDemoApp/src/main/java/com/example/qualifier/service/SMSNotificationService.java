package com.example.qualifier.service;

import org.springframework.stereotype.Service;

@Service("smsService")  // Important: Named bean
public class SMSNotificationService implements NotificationService {

    @Override
    public String sendNotification(String recipient, String message) {
        return "📱 SMS sent to " + recipient + ": " + message;
    }

    @Override
    public String getServiceType() {
        return "SMS Notification Service";
    }
}