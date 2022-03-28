package com.example.demo.repository;

import com.example.demo.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    // DuDH lấy List Employee
    @Query(value = "select * from  employee where delete_flag = false ", nativeQuery = true)
    Page<Employee> findAllEmployee(Pageable pageable);

    // DuDH tìm Employee theo Id
    @Query(value = "select * from employee where id=?", nativeQuery = true)
    Optional<Employee> findEployeeById(Integer id);

    // DuDH xoá nhân viên
    @Transactional
    @Modifying
    @Query(value = "update employee set delete_flag = 1 where id=?", nativeQuery = true)
    void deleteById(Integer id);

    @Transactional
    @Query(value = " select * from employee \n" +
            " where employee.name like %?1% or employee.date_of_birth like %?1% or employee.phone like %?1% and employee.delete_flag = 0 " +
            " order by employee.id desc ", nativeQuery = true,
            countQuery = " select count(*) from equipment \n " +
                    " where employee.name like %?1% or employee.date_of_birth like %?1% or employee.phone like %?1% and employee.delete_flag = 0 " +
                    " order by employee.id desc ")
    Page<Employee> findAllEmployeeByKeyword(String keyword,@Param("page") Pageable pageable);
}



