package com.example.demo.controller;

import com.example.demo.entity.equipment.Supplier;
import com.example.demo.entity.financial_statistics.Supplies;
import com.example.demo.service.impl.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @GetMapping(value = "/list")
    public ResponseEntity<Object> getList() {
        List<Supplier> supplierList = supplierService.getAll();
        return new ResponseEntity<>(supplierList, HttpStatus.OK);
    }
}
