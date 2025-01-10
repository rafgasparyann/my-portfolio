package tech.ultimatelogiclab.emproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.ultimatelogiclab.emproject.model.Employee;
import tech.ultimatelogiclab.emproject.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ApplicationController {
    private final EmployeeService employeeService;

    public ApplicationController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Employee> employees = employeeService.findAllEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }
}
