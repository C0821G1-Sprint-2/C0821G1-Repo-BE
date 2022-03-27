package com.example.demo.service.impl;

import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.equipment.Equipment;
import com.example.demo.repository.IEquipmentRepository;
import com.example.demo.service.IEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EquipmentServiceImpl implements IEquipmentService {

    @Autowired
    IEquipmentRepository iEquipmentRepository;


    @Override
    public Equipment findById(Integer id) {
        return iEquipmentRepository.findById(id).orElse(null);
    }



//    NghiaDM
    @Override
    public Page<Equipment> getAll(Pageable pageable) {
        return iEquipmentRepository.findAllEquipment(pageable);
    }

    @Override
    public Page<Equipment> findEquipmentByEquipmentType(Pageable pageable,Integer equipmentTypeID) {
        return this.iEquipmentRepository.findEquipment(pageable,equipmentTypeID);
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
