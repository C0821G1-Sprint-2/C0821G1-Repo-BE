package com.example.demo.repository;


import com.example.demo.entity.security.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser,Integer> {


    // BaoNHG tìm kiếm appuser theo usename
    @Query(value = "SELECT * FROM app_user WHERE username= :username ", nativeQuery = true)
    AppUser getAppUserByUsername(@Param("username") String username);

//    @Query(value = "SELECT * FROM app_users WHERE username= :username and isEnabled = false ", nativeQuery = true)
//    AppUser getAppUserByUsername(@Param("username") String username);

    // BaoNHG tìm appuser theo email
    @Query(value = "select * from app_user " +
            "where username= ?1", nativeQuery = true)
    AppUser findAppUserByEmail(String appUserName);
}
