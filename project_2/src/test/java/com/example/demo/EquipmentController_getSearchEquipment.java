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
public class EquipmentController_getSearchEquipment {

    @Autowired
    EquipmentRestController equipmentRestController;

    // Lỗi equipmentTypeId = null
    @Test
    public void searchEquipmentByEquipmentTypeID_7(){
        ResponseEntity<Page<Equipment>> responseEntity
                = equipmentRestController.findEquipmentByEquipmentTypeId
                (PageRequest.of(0,5),null);
        Assertions.assertEquals(400,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals(null,responseEntity.getBody().getContent().get(0).getEquipmentType().getId());
    }

    // Lỗi equipmentTypeId = 6 không tồn tại trong Data Base
    @Test
    public void searchEquipmentByEquipmentTypeID_9(){
        ResponseEntity<Page<Equipment>> responseEntity
                = equipmentRestController.findEquipmentByEquipmentTypeId
                (PageRequest.of(0,2),8);
        Assertions.assertEquals(400,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals(8,responseEntity.getBody().getContent().get(0).getEquipmentType().getId());
    }

    // Trả về Json chứa các record
    @Test
    public void searchEquipmentByEquipmentTypeID_11(){
        ResponseEntity<Page<Equipment>> responseEntity
                = equipmentRestController.findEquipmentByEquipmentTypeId
                (PageRequest.of(0,2),2);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals(2,responseEntity.getBody().getContent().get(0).getEquipmentType().getId());
    }

}
