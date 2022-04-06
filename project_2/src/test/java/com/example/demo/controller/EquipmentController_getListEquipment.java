package com.example.demo.controller;


import com.example.demo.entity.employee.Employee;
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
    EquipmentRestController equipmentController;

    //  Test trường đầu size bằng 0
    @Test
    public void getListEquipment_5() {
        ResponseEntity<Page<Equipment>> responseEntity =
                equipmentController.findEquipmentByKeyword("",0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }
    //  Test list trả về mảng json chứa đầu đủ các record trong table, tổng số trang và phân trang.
    @Test
    public void getListEquipment_6() {
        ResponseEntity<Page<Equipment>> responseEntity =
                equipmentController.findEquipmentByKeyword("",0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(7, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals(10, responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals("VT-0004", responseEntity.getBody().getContent().get(0).getCode());
        Assertions.assertEquals("1", responseEntity.getBody().getContent().get(0).getStatus());
        Assertions.assertEquals("2022-11-02", responseEntity.getBody().getContent().get(0).getExpired());
        Assertions.assertEquals("image2", responseEntity.getBody().getContent().get(0).getImage());
        Assertions.assertEquals("Dung dịch sát khuẩn", responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("100000", responseEntity.getBody().getContent().get(0).getPrice());

    }
}
