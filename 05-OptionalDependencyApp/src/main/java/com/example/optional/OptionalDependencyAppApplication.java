package com.example.optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OptionalDependencyAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OptionalDependencyAppApplication.class, args);
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ OPTIONAL DEPENDENCY DEMO STARTED");
        System.out.println("=".repeat(60));
        System.out.println("📌 Services Status:");
        System.out.println("   - Report Service: " + 
            (context.containsBean("reportService") ? "✅ PRESENT" : "❌ ABSENT"));
        System.out.println("   - Analytics Service: " + 
            (context.containsBean("analyticsService") ? "✅ PRESENT" : "❌ ABSENT"));
        System.out.println("\n🌐 Test URLs:");
        System.out.println("   GET  http://localhost:8083/api/notifications/status");
        System.out.println("   GET  http://localhost:8083/api/notifications/report");
        System.out.println("   GET  http://localhost:8083/api/notifications/analytics/status");
        System.out.println("=".repeat(60));
    }
}