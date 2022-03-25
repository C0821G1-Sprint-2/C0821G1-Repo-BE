package com.example.demo.service.impl;

import com.example.demo.entity.security.AppUser;
import com.example.demo.repository.IAppUserRepository;
import com.example.demo.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements IAppUserService {
    @Autowired
    IAppUserRepository iAppUserRepository;
    @Override
    public void createAppUser(AppUser appUser) {
        iAppUserRepository.createAppUser(appUser.getUsername(),appUser.getPassword());
    }
}
