package com.example.demo.controller;
import com.example.demo.entity.financial_statistics.Supplies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class SuppliesController_gitListSupplies {
    @Autowired
    SuppliesController suppliesController;
    //  Test trường đầu size bằng 0
    @Test
    public void getListSupplies_5() {
        ResponseEntity<Page<Supplies>> responseEntity =
                suppliesController.findAll(0,"","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    //  Test list trả về mảng json chứa đầu đủ các record trong table, tổng số trang và phân trang.
    @Test
    public void getListSupplies_6() {
        ResponseEntity<Page<Supplies>> responseEntity =
                suppliesController.findAll(0,"","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(10, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals("VT01", responseEntity.getBody().getContent().get(0).getCode());
        Assertions.assertEquals("Bông gòn", responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("130", responseEntity.getBody().getContent().get(0).getImportedMaterials());
        Assertions.assertEquals("100", responseEntity.getBody().getContent().get(0).getSalableMaterials());
        Assertions.assertEquals("20", responseEntity.getBody().getContent().get(0).getInventoryMaterials());
        Assertions.assertEquals("50", responseEntity.getBody().getContent().get(0).getDamagedMaterials());
        Assertions.assertEquals("2022-03-02", responseEntity.getBody().getContent().get(0).getStartDay());
        Assertions.assertEquals("2022-03-23", responseEntity.getBody().getContent().get(0).getEndDay());

    }
}
