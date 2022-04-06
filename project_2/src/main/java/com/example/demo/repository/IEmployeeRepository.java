package com.example.demo.repository;

import com.example.demo.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    //Bảo kiểm tìm kiếm nhân viên theo mã nhân viên
    @Query(value = "SELECT * " +
            "from employee  " +
            "where code =?1", nativeQuery = true)
    Employee getEmployeeByCode(String employeeCode);
}
