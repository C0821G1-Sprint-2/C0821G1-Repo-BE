package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.employee.Employee;

public interface IEmployeeService {
    void saveEmployee(Employee employee);
    void editEmployee(Employee employee);
    EmployeeDTO findByEmployeeId(Integer id);
}
