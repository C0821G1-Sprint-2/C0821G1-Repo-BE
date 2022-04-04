package com.example.demo.service.impl;

import com.example.demo.entity.employee.EmployeePosition;
import com.example.demo.repository.IEmployeePositionRepository;
import com.example.demo.service.IEmployeePositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePositionServiceImpl implements IEmployeePositionService {


    @Autowired
    private IEmployeePositionRepository iEmployeePositionRepository;

    @Override
    public List<EmployeePosition> getAllEmployeePosition() {
        return iEmployeePositionRepository.getAllEmployeePosition();
    }

    @Override
    public EmployeePosition findByIdEmployeePosition(Integer id) {
        return iEmployeePositionRepository.findById(id).orElse(null);
    }
}
