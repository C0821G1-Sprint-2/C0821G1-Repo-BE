package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.security.AppUser;

public interface UserService {
    AppUser changePassword(UserDTO changePasswordDTO);

    AppUser findById(Integer id);
}
