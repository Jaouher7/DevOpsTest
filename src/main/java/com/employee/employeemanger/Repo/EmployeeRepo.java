package com.employee.employeemanger.Repo;

import com.employee.employeemanger.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    void deleteEmpolyeeById(Long id);
    Optional<Employee> findEmployeeById(Long id);
}
