package com.example.demo.controller;


import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.employee.Employee;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    // PhienLD thêm mới nhân viên
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addEmployee( @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_MODIFIED);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }
    // PhienLD chỉnh sửa  nhân viên
    @PatchMapping(value = "/edit/{id}")
    public ResponseEntity<Object> editEmployee(@RequestBody  EmployeeDTO employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        employee.setDeleteFlag(false);
        employeeService.editEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
