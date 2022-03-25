package com.example.demo.repository;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO employee ( `code`,`name`, date_of_birth, gender, delete_flag,  image, phone,address, employee_position_id) \n" +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)", nativeQuery = true)
    void saveEmployee(String code, String name, String dateOfBirth, String gender, Boolean deleteFlag, String image, String phone, String address, Integer employeePositionId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employee \n" +
            "SET `code` = ?1, `name` = ?2, date_of_birth = ?3, delete_flag= ?4, gender= ?5, image = ?6, phone = ?7, address = ?8, employee_position_id = ?9\n" +
            "WHERE `id` = ?10", nativeQuery = true)
    void editEmployee(String code, String name, String dateOfBirth, Boolean deleteFlag, String gender,
                      String image, String phone, String address,
                      Integer employeePositionId, Integer id);

    @Query(nativeQuery = true)
    EmployeeDTO findEmployeeById(Integer employeeId);
}
