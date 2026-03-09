package com.example.optional.service;

public interface NotificationService {
    String sendNotification(String recipient, String message);
    String getServiceType();
}