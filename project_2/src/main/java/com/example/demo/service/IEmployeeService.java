package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import java.util.List;

public interface IEmployeeService {

    void editEmployee(Employee employee);

    EmployeeDTO findByEmployeeId(Integer id);

    Page<Employee> findAllEmployee(Pageable pageable);


    Page<Employee> findAllEmployeeByKeyword(String keyword, Pageable pageable);

    Optional<Employee> findEployeeById(Integer id);

    void deleteById(Integer id);

    Employee findEmployeeByCode(String employeeCode);

    void saveEmployee(Employee employee);


    Employee getEmployeeByUsername(String username);

    List<Employee> getAll();

    Boolean existsEmployeeByCode(String employeeCode);

//    boolean existsEmployeeByCode(String spaceCode);


    boolean checkCodeEmployee(String spaceCode);

}
