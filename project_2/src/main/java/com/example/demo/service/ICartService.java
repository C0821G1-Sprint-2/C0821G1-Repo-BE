package com.example.demo.service;

import com.example.demo.entity.cart.Cart;

public interface ICartService {

    void save(Cart cart);

    Cart findById(Integer id);
}
