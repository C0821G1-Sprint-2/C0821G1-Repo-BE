package com.example.demo.service.impl;

import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.equipment.Equipment;
import com.example.demo.repository.IEmployeeRepository;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAllEmployee(Pageable pageable) {
        return this.employeeRepository.findAllEmployee(pageable);
    }

    @Override
    public Optional<Employee> findEployeeById(Integer id) {
        return this.employeeRepository.findEployeeById(id);
    }

    @Override
    public void deleteById(Integer id) {
        this.employeeRepository.deleteById(id);
    }
}
