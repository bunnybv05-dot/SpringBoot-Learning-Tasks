package com.example.qualifier.service;

public interface NotificationService {
    String sendNotification(String recipient, String message);
    String getServiceType();
}