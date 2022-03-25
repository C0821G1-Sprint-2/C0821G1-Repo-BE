package com.example.demo.service.impl;

import com.example.demo.entity.equipment.Equipment;
import com.example.demo.repository.IEquipmentRepository;
import com.example.demo.service.IEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
