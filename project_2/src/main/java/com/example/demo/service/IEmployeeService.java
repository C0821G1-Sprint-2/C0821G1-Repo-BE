package com.example.demo.service;


import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.equipment.Equipment;

public interface IEmployeeService {

    Employee findEmployeeByCode(String employeeCode);

    void saveEmployee(Employee employee);
}
