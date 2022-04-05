package com.example.demo.service.impl;

import com.example.demo.entity.equipment.EquipmentType;
import com.example.demo.repository.IEquipmentTypeRepository;
import com.example.demo.service.IEquipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentTypeService implements IEquipmentTypeService {
    @Autowired
    private IEquipmentTypeRepository iEquipmentTypeRepository;

    @Override
    public List<EquipmentType> getAll() {
        return iEquipmentTypeRepository.findAll();
    }
}
