package com.example.demo.service;

import com.example.demo.dto.EquipmentDTO;
import com.example.demo.entity.equipment.Equipment;


public interface IEquipmentService {
    void addEquipment(Equipment equipment);
    void editEquipment(Equipment equipment);
    Equipment findById(Integer id);
}
