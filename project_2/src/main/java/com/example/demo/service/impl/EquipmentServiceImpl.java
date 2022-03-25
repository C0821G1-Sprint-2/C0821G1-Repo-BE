package com.example.demo.service.impl;

import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.equipment.Equipment;
import com.example.demo.repository.IEquipmentRepository;
import com.example.demo.service.IEmployeeService;
import com.example.demo.service.IEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
<<<<<<< HEAD
public class EquipmentServiceImpl  {
    @Autowired
    IEquipmentRepository iEquipmentRepository;
=======
public class EquipmentServiceImpl implements IEquipmentService {
    @Autowired
    IEquipmentRepository iEquipmentRepository;

    @Override
    public Equipment findById(Integer id) {
        return null;
    }
>>>>>>> 9fb543b13c68d16b2ebc4a3d7275e433337ea2ac
}
