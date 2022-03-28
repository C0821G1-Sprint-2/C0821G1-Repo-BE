package com.example.demo.controller;

import com.example.demo.entity.equipment.Equipment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class EquipmentController_getSearchEquipment {
    @Autowired
    EquipmentRestController equipmentController;

    // search trường name
    @Test
    public void searchEquipmentName(){
        ResponseEntity<Page<Equipment>> responseEntity
                = equipmentController.findEquipmentByKeyword
                ("Bông gòn",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Bông Gòn",responseEntity.getBody().getContent().get(0).getName());
    }
//
//    // search trường code
    @Test
    public void searchEquipmentCode(){
        ResponseEntity<Page<Equipment>> responseEntity
                = equipmentController.findEquipmentByKeyword
                ("VT-0004",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("VT-0004",responseEntity.getBody().getContent().get(0).getCode());
    }
//    // search trường price
    @Test
    public void searchEquipmentPrice(){
        ResponseEntity<Page<Equipment>> responseEntity
                = equipmentController.findEquipmentByKeyword
                ("100000",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("100000",responseEntity.getBody().getContent().get(0).getPrice());
    }
}
