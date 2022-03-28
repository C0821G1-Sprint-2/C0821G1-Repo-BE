package com.example.demo.controller;

import com.example.demo.entity.employee.Employee;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/employee")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService employeeService;

    // DuDH lấy List Employee
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Employee>> findAllEmployee(@PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employeeList = this.employeeService.findAllEmployee(pageable);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    // DuDH tìm Employee theo Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Integer id) {
        Optional<Employee> employeeOptional = this.employeeService.findEployeeById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }

    // DuDH xoá nhân viên
    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<Employee> deleteEmployees(@PathVariable("id") Integer id) {
        Optional<Employee> employeeOptional = this.employeeService.findEployeeById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.employeeService.deleteById(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }

}
