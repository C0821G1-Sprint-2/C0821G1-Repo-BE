//package com.example.demo.controller;
//
//import com.example.demo.entity.employee.Employee;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.ResponseEntity;
//
//@SpringBootTest
//public class EmployeeController_listEmployee {
//    @Autowired
//    EmployeeRestController employeeRestController;
//
//        //  Test trường đầu size bằng 0
//    @Test
//    public void getListEmployee_5() {
//        ResponseEntity<Page<Employee>> responseEntity =
//                employeeRestController.findAllEmployee(PageRequest.of(0, 2));
//        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
//    }
//        //  Test list trả về mảng json chứa đầu đủ các record trong table, tổng số trang và phân trang.
//    @Test
//    public void getListEmployee_6() {
//        ResponseEntity<Page<Employee>> responseEntity =
//                employeeRestController.findAllEmployee(PageRequest.of(0, 5));
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(10, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getId());
//        Assertions.assertEquals("NV-001", responseEntity.getBody().getContent().get(0).getCode());
//        Assertions.assertEquals("Nguyễn Văn A", responseEntity.getBody().getContent().get(0).getName());
//        Assertions.assertEquals("01/01/1991", responseEntity.getBody().getContent().get(0).getDateOfBirth());
//        Assertions.assertEquals("Nam", responseEntity.getBody().getContent().get(0).getGender());
//        Assertions.assertEquals("Quảng Nam", responseEntity.getBody().getContent().get(0).getAddress());
//        Assertions.assertEquals("0905111111", responseEntity.getBody().getContent().get(0).getPhone());
//
//    }
//}
//
