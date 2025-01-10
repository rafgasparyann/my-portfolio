package tech.ultimatelogiclab.emproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.ultimatelogiclab.emproject.model.Employee;
import tech.ultimatelogiclab.emproject.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployeePage() {
        return "add";
    }

    @PostMapping("/add")
    public String addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editEmployeePage(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
