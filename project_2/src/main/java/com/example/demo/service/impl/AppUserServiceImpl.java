package com.example.demo.service.impl;

import com.example.demo.entity.security.AppUser;
import com.example.demo.repository.IAppUserRepository;
import com.example.demo.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppUserServiceImpl implements IAppUserService {
    @Autowired
    IAppUserRepository iAppUserRepository;

    // BaoNHG
    @Override
    public AppUser findAppUserByUserName(String userName) {
        return iAppUserRepository.getAppUserByUsername(userName);
    }

    @Override
    public AppUser findAppUserByEmail(String email) {
        return iAppUserRepository.findAppUserByEmail(email);
    }
}
