package com.example.demo.controller;

import com.example.demo.entity.employee.Employee;
import com.example.demo.service.IEmployeeService;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    //Tìm nhân viên theo mã nhân viên
    @GetMapping(value = "/detail/{code}")
    public ResponseEntity<Employee> getEmployee(@PathVariable String code) {
        Employee employee = employeeService.findEmployeeByCode(code);
//        if (!employee.()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
