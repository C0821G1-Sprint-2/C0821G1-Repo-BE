package com.example.demo.service.impl;

import com.example.demo.entity.cart.Address;
import com.example.demo.repository.IAddressRepository;
import com.example.demo.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IAddressService {
    @Autowired
    IAddressRepository addressRepository;

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }
}
