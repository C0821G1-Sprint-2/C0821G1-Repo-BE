package com.example.demo.service;

import com.example.demo.entity.equipment.Equipment;
import org.springframework.stereotype.Service;


public interface IEquipmentService {
    Equipment findById(Integer id);
}
