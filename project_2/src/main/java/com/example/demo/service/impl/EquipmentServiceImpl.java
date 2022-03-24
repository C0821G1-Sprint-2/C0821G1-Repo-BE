package com.example.demo.service.impl;

import com.example.demo.entity.equipment.Equipment;
import com.example.demo.repository.IEquipmentRepository;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements IEmployeeService {
    @Autowired
    IEquipmentRepository iEquipmentRepository;

    @Override
    public Equipment findById(Integer id) {
        return iEquipmentRepository.findById(id).orElse(null);
    }
}
