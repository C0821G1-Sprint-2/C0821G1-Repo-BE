package com.example.demo.service;

import com.example.demo.entity.equipment.Equipment;


public interface IEquipmentService {
    Equipment findById(Integer id);
}
