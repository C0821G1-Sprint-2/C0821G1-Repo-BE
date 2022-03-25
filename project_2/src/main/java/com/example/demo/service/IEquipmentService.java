package com.example.demo.service;

import com.example.demo.entity.equipment.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface IEquipmentService {
    Optional<Equipment> findEquipmentById(Integer id);
    Page<Equipment> findAllEquipmentByKeyword(String keyword , Pageable pageable);
    void deleteEquipment(Integer id);
}
