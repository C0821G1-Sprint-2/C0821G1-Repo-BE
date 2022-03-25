package com.example.demo.repository;

import com.example.demo.entity.security.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Integer> {
}
