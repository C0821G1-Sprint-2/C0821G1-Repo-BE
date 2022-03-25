package com.example.demo.service;

import com.example.demo.entity.equipment.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface IEquipmentService {
    Equipment findById(Integer id);
    Page<Equipment> getAll(Pageable pageable);
}
