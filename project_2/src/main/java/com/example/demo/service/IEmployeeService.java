package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    void editEmployee(Employee employee);
    EmployeeDTO findByEmployeeId(Integer id);
    Page<Employee> findAllEmployee(Pageable pageable);

    List<Employee> findAllEmployee();

    Page<Employee> findAllEmployeeByKeyword(String keyword, Pageable pageable);

    Optional<Employee> findEployeeById(Integer id);

    void deleteById(Integer id);

    Employee findEmployeeByCode(String employeeCode);

    void saveEmployee(Employee employee);


}
