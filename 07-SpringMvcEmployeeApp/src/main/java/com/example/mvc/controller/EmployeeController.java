package com.example.mvc.controller;

import com.example.mvc.model.Employee;
import com.example.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    
    private final EmployeeService employeeService;
    
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
        System.out.println("✅ EmployeeController initialized");
    }
    
    // 1. LIST ALL EMPLOYEES
    @GetMapping
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("title", "Employee List");
        return "employee-list";
    }
    
    // 2. VIEW EMPLOYEE DETAILS
    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable Long id, Model model) {
        try {
            model.addAttribute("employee", employeeService.getEmployeeById(id));
            return "employee-detail";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
    
    // 3. SHOW ADD FORM
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", new String[]{"IT", "HR", "Finance", "Marketing"});
        return "employee-form";
    }
    
    // 4. SAVE NEW EMPLOYEE
    @PostMapping
    public String saveEmployee(@ModelAttribute Employee employee, 
                               RedirectAttributes redirectAttributes) {
        Employee saved = employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("message", 
            "Employee " + saved.getFullName() + " added successfully!");
        return "redirect:/employees";
    }
    
    // 5. SHOW EDIT FORM
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        try {
            model.addAttribute("employee", employeeService.getEmployeeById(id));
            model.addAttribute("departments", new String[]{"IT", "HR", "Finance", "Marketing"});
            return "employee-form";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
    
    // 6. UPDATE EMPLOYEE
    @PostMapping("/{id}")
    public String updateEmployee(@PathVariable Long id, 
                                 @ModelAttribute Employee employee,
                                 RedirectAttributes redirectAttributes) {
        employee.setId(id);
        employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("message", "Employee updated successfully!");
        return "redirect:/employees";
    }
    
    // 7. DELETE EMPLOYEE
    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id,
                                 RedirectAttributes redirectAttributes) {
        try {
            employeeService.deleteEmployee(id);
            redirectAttributes.addFlashAttribute("message", "Employee deleted successfully!");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/employees";
    }
    
    // 8. FILTER BY DEPARTMENT
    @GetMapping("/department/{dept}")
    public String getByDepartment(@PathVariable String dept, Model model) {
        model.addAttribute("employees", employeeService.getEmployeesByDepartment(dept));
        model.addAttribute("title", "Employees in " + dept + " Department");
        return "employee-list";
    }
}