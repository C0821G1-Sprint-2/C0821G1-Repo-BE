package com.example.demo.controller;

import com.example.demo.entity.financial_statistics.Financial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class FinancialController_searchFinancial {
@Autowired
    FinancialController financialController;
    // search trường tháng năm
    @Test
    public void searchFinancialMonthAndYear(){
        ResponseEntity<Page<Financial>> responseEntity
                = financialController.findAll
                (0,"1","2022");
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("1",responseEntity.getBody().getContent().get(0).getMonth());
        Assertions.assertEquals("2022",responseEntity.getBody().getContent().get(0).getYear());
    }

    // search trường tháng nhưng năm để trống
    @Test
    public void searchFinancialMonth(){
        ResponseEntity<Page<Financial>> responseEntity
                = financialController.findAll
                (0,"1","");
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("1",responseEntity.getBody().getContent().get(0).getMonth());
    }
    // search trường tháng nhưng năm để trống
    @Test
    public void searchFinancialYear(){
        ResponseEntity<Page<Financial>> responseEntity
                = financialController.findAll
                (0,"1","");
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("2022",responseEntity.getBody().getContent().get(0).getYear());
    }
}
