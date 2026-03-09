package com.example.optional.service.optional;

import org.springframework.stereotype.Component;

// @Component  // KEEP THIS COMMENTED to simulate missing dependency
public class AnalyticsService {
    
    public String trackEvent(String eventName) {
        return "📈 Analytics tracked: " + eventName;
    }
    
    public String getAnalyticsStatus() {
        return "Analytics Service is OPERATIONAL";
    }
}