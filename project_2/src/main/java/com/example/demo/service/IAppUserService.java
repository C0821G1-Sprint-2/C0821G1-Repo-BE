package com.example.demo.service;

import com.example.demo.entity.security.AppUser;

public interface IAppUserService {
    AppUser findAppUserByUserName(String userName);

    AppUser findAppUserByEmail(String email);


}
