package com.example.employee;

import com.example.employee.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EmployeeManagementAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(EmployeeManagementAppApplication.class, args);
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("✅ EMPLOYEE MANAGEMENT SYSTEM STARTED");
        System.out.println("=".repeat(70));
        
        // Demonstrate IoC and DI
        System.out.println("\n📌 Inversion of Control & Dependency Injection:");
        System.out.println("   - @Component: EmployeeRepository");
        System.out.println("   - @Service: EmployeeService");
        System.out.println("   - @RestController: EmployeeController");
        System.out.println("   - @Autowired: Constructor injection");
        
        // Show beans from container
        System.out.println("\n🔍 Beans in Spring Container:");
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            if (beanName.contains("employee") || beanName.contains("controller") || 
                beanName.contains("service") || beanName.contains("repository")) {
                System.out.println("   • " + beanName);
            }
        }
        
        // Show sample data
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        System.out.println("\n📊 Sample Employees:");
        employeeService.getAllEmployees().forEach(e -> 
            System.out.println("   • " + e.getFirstName() + " " + e.getLastName() + " - " + e.getDepartment())
        );
        
        System.out.println("\n🌐 REST API Endpoints (port 8084):");
        System.out.println("   POST   /api/employees");
        System.out.println("   GET    /api/employees");
        System.out.println("   GET    /api/employees/{id}");
        System.out.println("   PUT    /api/employees/{id}");
        System.out.println("   DELETE /api/employees/{id}");
        System.out.println("   GET    /api/employees/count");
        System.out.println("   GET    /api/employees/department/{dept}");
        System.out.println("=".repeat(70) + "\n");
    }
}