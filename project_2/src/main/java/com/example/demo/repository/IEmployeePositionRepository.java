package com.example.demo.repository;

import com.example.demo.entity.employee.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IEmployeePositionRepository extends JpaRepository<EmployeePosition, Integer> {
    @Modifying
    @Transactional
    @Query(value = "select *\n" +
            "from employee_position", nativeQuery = true)
    List<EmployeePosition> getAllEmployeePosition();

}
