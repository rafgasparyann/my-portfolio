package tech.ultimatelogiclab.emproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ultimatelogiclab.emproject.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
