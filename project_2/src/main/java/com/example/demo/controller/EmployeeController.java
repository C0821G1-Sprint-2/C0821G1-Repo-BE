package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.employee.Employee;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "api/employee", method = RequestMethod.GET)

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


    //Bảo tìm list nhân viên
    @GetMapping(value = "/list-select")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employeeList = employeeService.getAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    // PhienLD thêm mới nhân viên
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addEmployee(@RequestBody  @Valid EmployeeDTO employeeDTO, BindingResult bindingResult) {
        if (employeeService.existsEmployeeByCode(employeeDTO.getCode())) {
            bindingResult.rejectValue("code","Mã mặt bằng đã tồn tại");
        }

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        System.out.println(employeeDTO);
        employee.setDeleteFlag(false);
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }

    // PhienLD chỉnh sửa  nhân viên
    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<Object> editEmployee(@RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        employee.setDeleteFlag(false);
        employeeService.editEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);

    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Integer id) {
//        Optional<Employee> employeeOptional = this.employeeService.findEployeeById(id);
//        if (!employeeOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
//    }
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Employee> findEmployeeById1(@PathVariable("id") Integer id) {
        Optional<Employee> employeeOptional = this.employeeService.findEployeeById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }


    @GetMapping(value = "/list")
    public ResponseEntity<Page<Employee>> findAllEmployee(String keyword, @PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employeeList = this.employeeService.findAllEmployeeByKeyword(keyword, pageable);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<Employee> deleteEmployees(@PathVariable("id") Integer id) {
        Optional<Employee> employeeOptional = this.employeeService.findEployeeById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.employeeService.deleteById(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }

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

    @GetMapping("check/{code}")
    public ResponseEntity<Boolean> checkCode(@PathVariable String code){

        boolean checkCode = this.employeeService.checkCodeEmployee(code);

        return new ResponseEntity<>(checkCode,HttpStatus.OK);
    }
}
