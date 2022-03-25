package com.example.demo.service.impl;

import com.example.demo.dto.EquipmentDTO;
import com.example.demo.entity.equipment.Equipment;
import com.example.demo.repository.IEquipmentRepository;
import com.example.demo.service.IEmployeeService;
import com.example.demo.service.IEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements  IEquipmentService {
    @Autowired
    IEquipmentRepository iEquipmentRepository;

    @Override
    public Equipment findById(Integer id) {
        return iEquipmentRepository.findById(id).orElse(null);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        this.iEquipmentRepository.saveEquipment(
                equipment.getCode()
                ,equipment.getName()
                ,equipment.getEquipmentType().getId()
                ,equipment.getPrice()
                ,equipment.getExpired()
                ,equipment.getSupplier().getId()
                ,equipment.getImage());
    }

    @Override
    public void editEquipment(Equipment equipment) {
        this.iEquipmentRepository.editEquipment(
                equipment.getCode()
                ,equipment.getName()
                ,equipment.getEquipmentType().getId()
                ,equipment.getPrice()
                ,equipment.getExpired()
                ,equipment.getSupplier().getId()
                ,equipment.getImage()
                ,equipment.getId());
    }

}
