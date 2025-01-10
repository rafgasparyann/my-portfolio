package tech.ultimatelogiclab.emproject.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ultimatelogiclab.emproject.excaption.EmployeeNotFoundException;
import tech.ultimatelogiclab.emproject.model.Employee;
import tech.ultimatelogiclab.emproject.repositories.EmployeeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee by id: " + id + " was not found"));
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
