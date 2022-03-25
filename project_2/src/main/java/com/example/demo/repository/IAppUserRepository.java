package com.example.demo.repository;


import com.example.demo.entity.security.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser,Integer> {

    //Bảo đăng ký tài khoản nhân viên
    @Modifying
    @Transactional
    @Query(value = "insert into app_user(username," +
            "password) " +
            "values (?1,?2)", nativeQuery = true)
    void createAppUser(String username,
                       String password);
}
