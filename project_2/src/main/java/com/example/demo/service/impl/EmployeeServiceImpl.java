package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.employee.Employee;
import com.example.demo.repository.IEmployeeRepository;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.saveEmployee(employee.getCode(), employee.getName(),
                employee.getDateOfBirth(), employee.getGender(), employee.getDeleteFlag(),
                 employee.getImage(), employee.getPhone(),
                employee.getAddress(), employee.getEmployeePosition().getId());

    }

    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.editEmployee(employee.getCode(),employee.getName(), employee.getDateOfBirth(),
                employee.getDeleteFlag(), employee.getGender(), employee.getImage(), employee.getPhone(),
                employee.getAddress(), employee.getEmployeePosition().getId(),employee.getId());
    }

    @Override
    public EmployeeDTO findByEmployeeId(Integer id) {
        return employeeRepository.findEmployeeById(id);
    }
}
