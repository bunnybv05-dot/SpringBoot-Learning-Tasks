package com.example.mvc.repository;

import com.example.mvc.model.Employee;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EmployeeRepository {
    
    private final Map<Long, Employee> employeeMap = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    
    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(idGenerator.getAndIncrement());
        }
        employeeMap.put(employee.getId(), employee);
        return employee;
    }
    
    public List<Employee> findAll() {
        return new ArrayList<>(employeeMap.values());
    }
    
    public Employee findById(Long id) {
        return employeeMap.get(id);
    }
    
    public void deleteById(Long id) {
        employeeMap.remove(id);
    }
    
    public boolean existsById(Long id) {
        return employeeMap.containsKey(id);
    }
    
    // Initialize with sample data
    public void initSampleData() {
        save(new Employee(null, "John", "Doe", "john.doe@example.com", "IT", 75000));
        save(new Employee(null, "Jane", "Smith", "jane.smith@example.com", "HR", 65000));
        save(new Employee(null, "Bob", "Johnson", "bob.johnson@example.com", "IT", 80000));
        save(new Employee(null, "Alice", "Williams", "alice.williams@example.com", "Finance", 70000));
    }
}