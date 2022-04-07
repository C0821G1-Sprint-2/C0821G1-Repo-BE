package com.example.demo.service.impl;

import com.example.demo.entity.equipment.Supplier;
import com.example.demo.repository.ISupplierRepository;
import com.example.demo.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierService implements ISupplierService {
    @Autowired
    private ISupplierRepository iSupplierRepository;
    @Override
    public List<Supplier> getAll() {
        return iSupplierRepository.findAll();
    }
}
