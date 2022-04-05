package com.example.demo.controller;

import com.example.demo.entity.equipment.EquipmentType;
import com.example.demo.service.impl.EquipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/equipmentType")
public class EquipmentTypeController {

    @Autowired
    private EquipmentTypeService equipmentTypeService;
    @GetMapping(value = "/list")
    public ResponseEntity<Object> getList(){
        List<EquipmentType> equipmentTypeList = equipmentTypeService.getAll();
        return new ResponseEntity<>(equipmentTypeList, HttpStatus.OK);
    }
}
