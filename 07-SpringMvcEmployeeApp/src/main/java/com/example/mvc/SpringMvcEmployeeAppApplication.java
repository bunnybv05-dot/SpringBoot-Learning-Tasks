package com.example.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcEmployeeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcEmployeeAppApplication.class, args);
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("✅ SPRING MVC EMPLOYEE APP STARTED");
        System.out.println("=".repeat(70));
        System.out.println("📌 MVC Flow (No XML Configuration):");
        System.out.println("   1. @Controller handles HTTP requests");
        System.out.println("   2. @Service contains business logic");
        System.out.println("   3. @Repository manages data");
        System.out.println("   4. Model carries data to View");
        System.out.println("   5. Thymeleaf renders HTML response");
        System.out.println("\n🌐 Open in browser:");
        System.out.println("   ┌─────────────────────────────────────┐");
        System.out.println("   │ http://localhost:8085/employees    │");
        System.out.println("   │ http://localhost:8085/employees/1  │");
        System.out.println("   │ http://localhost:8085/employees/new│");
        System.out.println("   └─────────────────────────────────────┘");
        System.out.println("=".repeat(70) + "\n");
    }
}