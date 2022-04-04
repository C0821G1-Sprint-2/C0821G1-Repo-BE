package com.example.demo.controller;

import com.example.demo.entity.employee.EmployeePosition;
import com.example.demo.service.IEmployeePositionService;
import com.example.demo.service.impl.EmployeePositionServiceImpl;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RequestMapping(value = "api/employee-position")
public class EmployeePositionController {
    @Autowired
    IEmployeePositionService employeePositionService;
    @GetMapping(value ="/list")
    public ResponseEntity<Object> getListEmployeePosition(){
        List<EmployeePosition> employeePositionList = employeePositionService.getAllEmployeePosition();
        return new ResponseEntity<>(employeePositionList, HttpStatus.OK);
    }
}
