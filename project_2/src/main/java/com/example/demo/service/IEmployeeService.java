package com.example.demo.service;

import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.equipment.Equipment;

import java.util.List;

public interface IEmployeeService {

    Employee findEmployeeByCode(String employeeCode);

    void saveEmployee(Employee employee);

    Employee getEmployeeByUsername(String username);

    List<Employee> getAll();

    Boolean existsEmployeeByCode(String employeeCode);
}
