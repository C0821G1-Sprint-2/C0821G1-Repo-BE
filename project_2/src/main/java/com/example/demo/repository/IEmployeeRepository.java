package com.example.demo.repository;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO employee ( `code`,`name`, date_of_birth, gender, delete_flag,  image, phone,address, employee_position_id) \n" +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)", nativeQuery = true)
    void saveEmployee(String code, String name, String dateOfBirth, String gender, Boolean deleteFlag, String image, String phone, String address, Integer employeePositionId);


    // DuDH lấy List Employee

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

    @Query(value = "select * from  employee where delete_flag = false ", nativeQuery = true)
    Page<Employee> findAllEmployee(Pageable pageable);

    // DuDH lấy List Employee
    @Query(value = "select * from  employee where delete_flag = false ", nativeQuery = true)
    List<Employee> findAllEmployee();

    // DuDH tìm Employee theo Id
    @Query(value = "select * from employee where id=?", nativeQuery = true)
    Optional<Employee> findEployeeById(Integer id);

    // DuDH xoá nhân viên
    @Transactional
    @Modifying
    @Query(value = "update employee set delete_flag = 1 where id=?", nativeQuery = true)
    void deleteById(Integer id);

    // DuDH tìm kiếm nhân viên
    @Transactional
    @Query(value = " select * from employee \n" +
            " where employee.name like %?1% or employee.date_of_birth like %?1% or employee.phone like %?1% and employee.delete_flag = 0 " +
            " order by employee.id desc ", nativeQuery = true,
            countQuery = " select count(*) from employee \n " +
                    " where employee.name like %?1% or employee.date_of_birth like %?1% or employee.phone like %?1% and employee.delete_flag = 0 " +
                    " order by employee.id desc ")
    Page<Employee> findAllEmployeeByKeyword(String keyword,@Param("page") Pageable pageable);

    //Bảo kiểm tìm kiếm nhân viên theo mã nhân viên
    @Query(value = "SELECT * " +
            "from employee  " +
            "where code =?1", nativeQuery = true)
    Employee getEmployeeByCode(String employeeCode);

    @Query(value = "SELECT * " +
            "from employee  " +
            "where code =?1", nativeQuery = true)
    Employee existsEmployeeByCode(String code);
}



