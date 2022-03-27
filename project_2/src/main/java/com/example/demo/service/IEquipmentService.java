package com.example.demo.service;

import com.example.demo.entity.equipment.Equipment;
import org.apache.catalina.LifecycleState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IEquipmentService {
    Page<Equipment> getAll(Pageable pageable);
    Page<Equipment> findEquipmentByEquipmentType(Pageable pageable, Integer equipmentTypeID);
    public Equipment findById(Integer id);
    Optional<Equipment> findEquipmentById(Integer id);
    Page<Equipment> findAllEquipmentByKeyword(String keyword , Pageable pageable);
    void deleteEquipment(Integer id);

}
