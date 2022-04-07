package com.example.demo.service.impl;

import com.example.demo.entity.cart.Address;
import com.example.demo.entity.cart.Cart;
import com.example.demo.repository.ICartRepository;
import com.example.demo.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    ICartRepository iCartRepository;

    @Override
    public void save(Cart cart) {
        iCartRepository.save(cart);
    }

    @Override
    public Cart findById(Integer id) {
        return iCartRepository.findById(id).orElse(null);
    }

}
