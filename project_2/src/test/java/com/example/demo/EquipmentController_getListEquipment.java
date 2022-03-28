package com.example.demo;

import com.example.demo.controller.EquipmentRestController;
import com.example.demo.entity.equipment.Equipment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class EquipmentController_getListEquipment {

    @Autowired
    EquipmentRestController equipmentRestController;

    //  Test trường đầu size bằng 0
    @Test
    public void getListEmployee_5() {
        ResponseEntity<Page<Equipment>> responseEntity =
                equipmentRestController.equipmentList(PageRequest.of(0, 2));
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }
    //  Test list trả về mảng json chứa đầu đủ các record trong table, tổng số trang và phân trang.
    @Test
    public void getListEmployee_6() {
        ResponseEntity<Page<Equipment>> responseEntity =
                equipmentRestController.equipmentList(PageRequest.of(0, 2));
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals("VT-0001", responseEntity.getBody().getContent().get(0).getCode());
        Assertions.assertEquals("Bông Gòn", responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getEquipmentType().getId());
    }
}
