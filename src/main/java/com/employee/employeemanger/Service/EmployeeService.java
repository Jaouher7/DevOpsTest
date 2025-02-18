package com.employee.employeemanger.Service;

import com.employee.employeemanger.Model.Employee;
import com.employee.employeemanger.Repo.EmployeeRepo;
import com.employee.employeemanger.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
//this is a service 
@Service
public class EmployeeService {
    private final EmployeeService employeeService;
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeService employeeService, EmployeeRepo employeeRepo) {
        this.employeeService = employeeService;
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id "+ id + " not found"));
    }
    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmpolyeeById(id);
    }
}
