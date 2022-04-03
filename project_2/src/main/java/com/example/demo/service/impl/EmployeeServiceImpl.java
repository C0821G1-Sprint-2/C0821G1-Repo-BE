package com.example.demo.service.impl;

import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.equipment.Equipment;
import com.example.demo.repository.IEmployeeRepository;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;



    //Bảo tìm nhân viên theo mã nhân viên
    @Override
    public Employee findEmployeeByCode(String employeeCode) {
        return employeeRepository.getEmployeeByCode(employeeCode);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        return employeeRepository.findEmployeeByAppUser(username);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Boolean existsEmployeeByCode(String employeeCode) {
        return employeeRepository.getEmployeeByCode(employeeCode) != null;
    }
}
