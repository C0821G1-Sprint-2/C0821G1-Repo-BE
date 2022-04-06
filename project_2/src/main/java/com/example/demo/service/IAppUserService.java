package com.example.demo.service;

import com.example.demo.entity.security.AppUser;

public interface IAppUserService {
    AppUser findAppUserByUserName(String userName);

    AppUser findAppUserByUsername(String email);

    Boolean existAppUserByUsername(String userName);
}
