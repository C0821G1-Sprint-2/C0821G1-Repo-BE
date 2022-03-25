package com.example.demo.service.impl;

import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.equipment.Equipment;
import com.example.demo.repository.IEquipmentRepository;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl  {
    @Autowired
    IEquipmentRepository iEquipmentRepository;
}
