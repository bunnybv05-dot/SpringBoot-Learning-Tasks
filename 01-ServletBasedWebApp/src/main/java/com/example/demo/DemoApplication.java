package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan  // Important: This enables servlet scanning for @WebServlet annotations
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        
        // Optional: Console output to confirm startup
        System.out.println("\n==================================================");
        System.out.println("✅ Application Started Successfully!");
        System.out.println("📍 Server running on: http://localhost:9090");
        System.out.println("📍 Context path: /myapp");
        System.out.println("📍 Test your servlet: http://localhost:9090/myapp/hello");
        System.out.println("==================================================\n");
    }
}