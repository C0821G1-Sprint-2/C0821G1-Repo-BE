package com.example.demo.controller;


import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.security.AppUser;
import com.example.demo.entity.security.Roles;
import com.example.demo.service.impl.AppUserServiceImpl;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/api/appuser")
public class AppUserController {
    @Autowired
    AppUserServiceImpl appUserService;

    @Autowired
    EmployeeServiceImpl employeeService;


    //Bảo đăng ký tài khoản
    @PostMapping(value = "/create/{code}")
    public ResponseEntity<Object> createAppUser(@RequestBody AppUser appUser,
                                                @PathVariable String code,
                                                BindingResult bindingResult) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(code);
        Employee employee = employeeService.findEmployeeByCode(code);
        if (!employeeService.existsEmployeeByCode(code)) {
            bindingResult.rejectValue("username", "Mã nhân viên không tồn tại");
        }
        else if(employee.getAppUser() != null){
            bindingResult.rejectValue("username", "Nhân viên này đã có tài khoản");
        }
        else if (appUserService.existAppUserByUsername(appUser.getUsername())) {
            bindingResult.rejectValue("username", "Tên tài khoản đã tồn tại");
        }

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        } else {
            //set role
            Set<Roles> roleList = new HashSet<>();
            Roles roles = new Roles();
            if (employee.getEmployeePosition().getId() == 1) {
                roles.setId(2);
            } else {
                roles.setId(1);
            }
            roleList.add(roles);
            appUser.setRoles(roleList);
            appUser.setDeleted(false);
            appUser.setEnabled(true);
            appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));

            //Bảo đăng ký tài khoản nhân viên
            employee.setAppUser(appUser);

            employeeService.saveEmployee1(employee);


            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
