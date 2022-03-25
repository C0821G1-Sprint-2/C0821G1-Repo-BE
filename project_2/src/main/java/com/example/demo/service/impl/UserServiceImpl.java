package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.security.AppUser;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserServiceImpl implements UserService {
    final
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AppUser changePassword(UserDTO changePasswordDTO) {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        System.out.println(userDTO.getId());
//        AppUser appUser = userRepository.findById(userDTO.getId()).orElse(null);
//        System.out.println(appUser.getPassword());
//        System.out.println("bcryp" + bCryptPasswordEncoder.encode(appUser.getPassword()));
//        if (appUser != null ) {
//
//            if (bCryptPasswordEncoder.matches(userDTO.getCurrentPassword(),appUser.getPassword())) {
//                System.out.println("vào");
//                if (userDTO.getNewPassword().equals(userDTO.getConfirmPassword())) {
//                    appUser.setPassword(bCryptPasswordEncoder.encode(userDTO.getNewPassword()));
//                    System.out.println("hahha" +
//                            appUser.getPassword());
//                    return userRepository.save(appUser);
//                }
//            } else {
//                return null;
//            }
//        }
        return null;
    }

    @Override
    public AppUser findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}
