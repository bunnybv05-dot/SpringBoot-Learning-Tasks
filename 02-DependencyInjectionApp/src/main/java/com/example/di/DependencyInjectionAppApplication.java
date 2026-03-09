package com.example.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DependencyInjectionAppApplication.class, args);
        
        System.out.println("\n============================================================");
        System.out.println("✅ DEPENDENCY INJECTION APP STARTED");
        System.out.println("============================================================");
        System.out.println("📌 Field Injection Demo:");
        System.out.println("   - Controller: GreetingController");
        System.out.println("   - Service: GreetingServiceImpl");
        System.out.println("   - Injection Type: @Autowired on field");
        System.out.println("\n🌐 Test URLs:");
        System.out.println("   • http://localhost:8080/api/greetings/personal/Bhavesh");
        System.out.println("   • http://localhost:8080/api/greetings/welcome?name=Bhavesh");
        System.out.println("   • http://localhost:8080/api/greetings/message");
        System.out.println("============================================================");
    }
}