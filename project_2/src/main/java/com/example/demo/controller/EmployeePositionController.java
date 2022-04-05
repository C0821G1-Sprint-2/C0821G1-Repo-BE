package com.example.demo.controller;

import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.employee.EmployeePosition;
import com.example.demo.service.IEmployeePositionService;
import com.example.demo.service.impl.EmployeePositionServiceImpl;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeePosition> findPosition(@PathVariable("id") Integer id) {
        EmployeePosition employeePosition = this.employeePositionService.findByIdEmployeePosition(id);
        if (employeePosition == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeePosition, HttpStatus.OK);
    }
}
