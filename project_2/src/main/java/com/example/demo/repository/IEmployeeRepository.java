package com.example.demo.repository;

import com.example.demo.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from  employee where delete_flag = false ", nativeQuery = true)
    Page<Employee> findAllEmployee(Pageable pageable);

    @Query(value = "select * from employee where id=?", nativeQuery = true)
    Optional<Employee> findEployeeById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update employee set delete_flag = 1 where id=?", nativeQuery = true)
    void deleteById(Integer id);

}



