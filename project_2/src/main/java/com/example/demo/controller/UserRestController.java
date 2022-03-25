package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.security.AppUser;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/employee")
public class UserRestController {
    final
    UserServiceImpl userServiceImpl;

    public UserRestController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    /**
     * created VyLTT
     * method updatePassword
     *
     * @param userDTO
     * @return
     */

    @PutMapping("/changePassword")
    public ResponseEntity<AppUser> passwordUser(@RequestBody UserDTO userDTO) {
        if (userDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("controller" + userDTO);
        AppUser appUser = userServiceImpl.changePassword(userDTO);
        if (appUser == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }
}
