package com.example.demo.service.account.impl;


import com.example.demo.entity.security.AppUser;
import com.example.demo.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// NghiaDM
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private IAppUserRepository iAppUserRepository;

    @Override
    public MyUserDetailsImpl loadUserByUsername(String s) throws UsernameNotFoundException {

        AppUser appUser = iAppUserRepository.getAppUserByUsername(s);
        return new MyUserDetailsImpl(appUser);
    }
}
