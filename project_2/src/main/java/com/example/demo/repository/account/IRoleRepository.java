package com.example.demo.repository.account;
import com.example.demo.entity.security.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IRoleRepository extends JpaRepository<Roles, Integer> {
}
