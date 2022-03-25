package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface IEmployeeService {
    void saveEmployee(Employee employee);
    void editEmployee(Employee employee);
    EmployeeDTO findByEmployeeId(Integer id);
    Page<Employee> findAllEmployee(Pageable pageable);

    Optional<Employee> findEployeeById(Integer id);

    void deleteById(Integer id);
}
