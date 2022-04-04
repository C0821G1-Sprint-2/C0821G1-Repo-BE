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
public class FinancialController_getListFinancial {
    @Autowired
    FinancialController financialController;
    //  Test trường đầu size bằng 0
    @Test
    public void getListFinancial_5() {
        ResponseEntity<Page<Financial>> responseEntity =
                financialController.findAll(0,"","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    //  Test list trả về mảng json chứa đầu đủ các record trong table, tổng số trang và phân trang.
    @Test
    public void getListFinancial_6() {
        ResponseEntity<Page<Financial>> responseEntity =
                financialController.findAll(0,"","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals("2022", responseEntity.getBody().getContent().get(0).getYear());
        Assertions.assertEquals("1", responseEntity.getBody().getContent().get(0).getMonth());
        Assertions.assertEquals(8.0E7, responseEntity.getBody().getContent().get(0).getGrossRevenue());
        Assertions.assertEquals(5.2E7, responseEntity.getBody().getContent().get(0).getTotalExpenditure());
        Assertions.assertEquals(2.8E7, responseEntity.getBody().getContent().get(0).getRevenue());
        Assertions.assertEquals(7.0E7, responseEntity.getBody().getContent().get(0).getSell());
        Assertions.assertEquals(1.0E7, responseEntity.getBody().getContent().get(0).getManufacture());
        Assertions.assertEquals(2.0E7, responseEntity.getBody().getContent().get(0).getImportGoods());
        Assertions.assertEquals(7000000.0, responseEntity.getBody().getContent().get(0).getPayCustomer());
        Assertions.assertEquals(1.0E7, responseEntity.getBody().getContent().get(0).getCancel());

    }
}
