package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component  // Marks this as a Spring bean
public class EmployeeRepository {
    
    // In-memory storage
    private final Map<Long, Employee> employeeMap = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    
    // Create
    public Employee save(Employee employee) {
        Long id = idGenerator.getAndIncrement();
        employee.setId(id);
        employeeMap.put(id, employee);
        return employee;
    }
    
    // Read all
    public List<Employee> findAll() {
        return new ArrayList<>(employeeMap.values());
    }
    
    // Read by ID
    public Employee findById(Long id) {
        return employeeMap.get(id);
    }
    
    // Update
    public Employee update(Employee employee) {
        if (employee.getId() != null && employeeMap.containsKey(employee.getId())) {
            employeeMap.put(employee.getId(), employee);
            return employee;
        }
        return null;
    }
    
    // Delete
    public boolean deleteById(Long id) {
        return employeeMap.remove(id) != null;
    }
    
    // Check exists
    public boolean existsById(Long id) {
        return employeeMap.containsKey(id);
    }
    
    // Get count
    public long count() {
        return employeeMap.size();
    }
    
    // Find by department
    public List<Employee> findByDepartment(String department) {
        return employeeMap.values().stream()
            .filter(e -> e.getDepartment().equalsIgnoreCase(department))
            .toList();
    }
    
    // Initialize with sample data
    public void initSampleData() {
        save(new Employee(null, "John", "Doe", "john.doe@example.com", "IT", 75000));
        save(new Employee(null, "Jane", "Smith", "jane.smith@example.com", "HR", 65000));
        save(new Employee(null, "Bob", "Johnson", "bob.johnson@example.com", "IT", 80000));
        save(new Employee(null, "Alice", "Williams", "alice.williams@example.com", "Finance", 70000));
    }
}