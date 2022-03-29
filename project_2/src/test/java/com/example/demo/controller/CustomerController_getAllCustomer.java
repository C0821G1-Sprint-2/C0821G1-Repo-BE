package com.example.demo.controller;

import com.example.demo.entity.customer.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;


@SpringBootTest
public class CustomerController_getAllCustomer {

    @Autowired
    private CustomerRestController customerRestController;

    //      DuongNT- customer list - size = 0
    @Test
    public void getListCustomer_5() {
        ResponseEntity<Page<Customer>> responseEntity
                = this.customerRestController.showListCustomer(PageRequest.of(0, 4));

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //      DuongNT- customer list - size > 0
    @Test
    public void getListCustomer_6() {
        ResponseEntity<Page<Customer>> responseEntity
                = this.customerRestController.showListCustomer(PageRequest.of(0, 5));

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(16, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Nguyễn Đình Hòa",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("0905123456",
                responseEntity.getBody().getContent().get(0).getPhone());
    }
}


