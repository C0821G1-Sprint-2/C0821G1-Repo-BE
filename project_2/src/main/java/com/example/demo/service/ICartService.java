package com.example.demo.service;

import com.example.demo.entity.cart.Address;
import com.example.demo.entity.cart.Cart;

import java.util.List;

public interface ICartService {

    void save(Cart cart);

    Cart findById(Integer id);

}
