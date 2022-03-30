package com.example.demo.service.impl;


import com.example.demo.entity.employee.Employee;
import com.example.demo.repository.IEmployeeRepository;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<Employee> findAllEmployee() {
        return this.employeeRepository.findAllEmployee();
    }

    @Override
    public Page<Employee> findAllEmployeeByKeyword(String keyword, Pageable pageable) {
        return this.employeeRepository.findAllEmployeeByKeyword(keyword, pageable);
    }

    @Override
    public Optional<Employee> findEployeeById(Integer id) {
        return this.employeeRepository.findEployeeById(id);
    }

    @Override
    public void deleteById(Integer id) {
        this.employeeRepository.deleteById(id);
    }
    //Bảo tìm nhân viên theo mã nhân viên
    @Override
    public Employee findEmployeeByCode(String employeeCode) {
        return employeeRepository.getEmployeeByCode(employeeCode);
    }
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);

    }
}
