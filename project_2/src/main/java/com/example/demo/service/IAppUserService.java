package com.example.demo.service;

import com.example.demo.entity.security.AppUser;

public interface IAppUserService {
    public void createAppUser(AppUser appUser);
    AppUser findAppUserByUserName(String userName);

    void saveAppUser(AppUser appUser);

    AppUser findAppUserByEmail(String email);


}
