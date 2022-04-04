package com.example.demo.controller;

import com.example.demo.entity.financial_statistics.Financial;
import com.example.demo.entity.financial_statistics.Supplies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class SuppliesController_searchSupplies {
    @Autowired
    SuppliesController suppliesController;
    // search trường tháng năm
    @Test
    public void searchFinancialMonthAndYear(){
        ResponseEntity<Page<Supplies>> responseEntity
                = suppliesController.findAll
                (0,"2022-03-02","2022-03-23");
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(10, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("2022-03-02",responseEntity.getBody().getContent().get(0).getStartDay());
        Assertions.assertEquals("2022-03-23",responseEntity.getBody().getContent().get(0).getEndDay());
    }

    // search trường Ngày bắt đầu nhưng ngày kết thúc để trống
    @Test
    public void searchSupplieslStartDay(){
        ResponseEntity<Page<Supplies>> responseEntity
                = suppliesController.findAll
                (0,"2022-03-02","");
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(10, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("2022-03-02",responseEntity.getBody().getContent().get(0).getStartDay());
    }
    // search trường ngày kết thúc nhưng Ngày bắt đầu để trống
    @Test
    public void searchFinancialYear(){
        ResponseEntity<Page<Supplies>> responseEntity
                = suppliesController.findAll
                (0,"","2022-03-23");
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(10, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("2022-03-23",responseEntity.getBody().getContent().get(0).getEndDay());
    }
}
