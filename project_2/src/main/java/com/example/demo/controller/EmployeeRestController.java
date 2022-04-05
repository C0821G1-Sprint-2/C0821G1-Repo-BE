package com.example.demo.controller;

import com.example.demo.entity.employee.Employee;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "api/employees")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService employeeService;

    // DuDH lấy List Employee
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Employee>> findAllEmployee(@PageableDefault(value = 3) Pageable pageable) {
        Page<Employee> employeeList = this.employeeService.findAllEmployee(pageable);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
//    @GetMapping(value = "/list")
//    public ResponseEntity<List<Employee>> findAllEmployee() {
//        List<Employee> employeeList = this.employeeService.findAllEmployee();
//        if (employeeList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(employeeList, HttpStatus.OK);
//    }

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

    // DuDH tìm kiếm nhân viên theo keyword
    @GetMapping("/-list")
    public ResponseEntity<Page<Employee>> findContractByNameAndCodeAndDate(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page
    ) {

        Pageable pageable = PageRequest.of(page, 2);
        Page<Employee> employeeNewPage = employeeService.findAllEmployeeByKeyword(keyword, pageable);
        System.out.println(employeeNewPage);
        if (employeeNewPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeNewPage, HttpStatus.OK);

    }
}
