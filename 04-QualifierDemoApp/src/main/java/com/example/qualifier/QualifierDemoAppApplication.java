package com.example.qualifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class QualifierDemoAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(QualifierDemoAppApplication.class, args);
        
        System.out.println("\n============================================================");
        System.out.println("✅ QUALIFIER DEMO APP STARTED");
        System.out.println("============================================================");
        System.out.println("📌 Multiple Bean Implementations:");
        System.out.println("   - Interface: NotificationService");
        System.out.println("   - Email Service: @Service(\"emailService\")");
        System.out.println("   - SMS Service: @Service(\"smsService\")");
        System.out.println("   - Resolution: @Qualifier annotation");
        System.out.println("\n🌐 Test URLs:");
        System.out.println("   POST http://localhost:8082/api/notifications/email?to=user@test.com&message=Hello");
        System.out.println("   POST http://localhost:8082/api/notifications/sms?to=1234567890&message=Hi");
        System.out.println("   GET  http://localhost:8082/api/notifications/email/info");
        System.out.println("   GET  http://localhost:8082/api/notifications/sms/info");
        System.out.println("============================================================");
    }
}