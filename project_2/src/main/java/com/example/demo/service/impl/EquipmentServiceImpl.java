package com.example.demo.service.impl;
import com.example.demo.entity.equipment.Equipment;
import com.example.demo.repository.IEquipmentRepository;
import com.example.demo.service.IEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Optional<Equipment> findEquipmentById(Integer id) {
        return this.iEquipmentRepository.findEquipmentById(id);
    }

    @Override
    public Page<Equipment> findAllEquipmentByKeyword(String keyword, Pageable pageable) {
        return this.iEquipmentRepository.findAllContractByKeyword(keyword,pageable);
    }

    @Override
    public void deleteEquipment(Integer id) {
        this.iEquipmentRepository.deleteEquipment(id);
    }

}
