package com.example.demo.service;


import com.example.demo.entity.employee.Employee;


public interface IEmployeeService {
    Employee findEmployeeByCode(String employeeCode);
    void saveEmployee(Employee employee);

}
