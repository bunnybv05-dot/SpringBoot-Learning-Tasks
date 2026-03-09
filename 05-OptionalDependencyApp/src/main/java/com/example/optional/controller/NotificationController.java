package com.example.optional.controller;

import com.example.optional.service.NotificationService;
import com.example.optional.service.optional.ReportService;
import com.example.optional.service.optional.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    // Regular required dependencies
    private final NotificationService emailService;
    private final NotificationService smsService;
    
    // OPTIONAL DEPENDENCIES - with required=false
    @Autowired(required = false)
    private ReportService reportService;
    
    @Autowired(required = false)
    private AnalyticsService analyticsService;
    
    // Constructor for required dependencies
    @Autowired
    public NotificationController(
            @Qualifier("emailService") NotificationService emailService,
            @Qualifier("smsService") NotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
        System.out.println("✅ Controller initialized");
    }
    
    // Basic endpoints
    @PostMapping("/email")
    public String sendEmail(@RequestParam String to, @RequestParam String message) {
        return emailService.sendNotification(to, message);
    }
    
    @PostMapping("/sms")
    public String sendSMS(@RequestParam String to, @RequestParam String message) {
        return smsService.sendNotification(to, message);
    }
    
    // OPTIONAL DEPENDENCY ENDPOINTS - with null handling
    
    @GetMapping("/report")
    public String getReport(@RequestParam(defaultValue = "Daily") String type) {
        // Method 1: Traditional null check
        if (reportService != null) {
            return reportService.generateReport(type);
        } else {
            return "⚠️ Report Service is not available. Please try later.";
        }
    }
    
    @GetMapping("/analytics/status")
    public String getAnalyticsStatus() {
        // Method 2: Ternary operator
        return (analyticsService != null) 
            ? analyticsService.getAnalyticsStatus()
            : "⚠️ Analytics Service is not installed.";
    }
    
    @GetMapping("/report/status")
    public String getReportStatus() {
        // Method 3: Direct check with fallback
        return (reportService != null) 
            ? reportService.getReportStatus()
            : "⚠️ Report Service is missing.";
    }
    
    @GetMapping("/track")
    public String trackEvent(@RequestParam String event) {
        // Method 4: Different fallback message
        if (analyticsService != null) {
            return analyticsService.trackEvent(event);
        }
        return "⚠️ Tracking unavailable - Analytics Service not present";
    }
    
    @GetMapping("/status")
    public String getAllServicesStatus() {
        StringBuilder status = new StringBuilder("📊 Services Status:\n");
        status.append("- Email Service: ✅ Active\n");
        status.append("- SMS Service: ✅ Active\n");
        status.append("- Report Service: ").append(reportService != null ? "✅ Active" : "⚠️ Not Available").append("\n");
        status.append("- Analytics Service: ").append(analyticsService != null ? "✅ Active" : "⚠️ Not Available");
        return status.toString();
    }
}