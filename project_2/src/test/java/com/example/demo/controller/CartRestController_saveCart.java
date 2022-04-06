package com.example.demo.controller;

import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.customer.Customer;
import com.example.demo.entity.equipment.Equipment;
import com.example.demo.service.impl.CustomerServiceImpl;
import com.example.demo.service.impl.EquipmentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartRestController_saveCart {
    @Autowired
    CustomerServiceImpl customerServicel;

    @Autowired
    EquipmentServiceImpl equipmentService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    /**
     * Create:DuyNP
     * Method: Test saveCart_13() item = null
     */
    @Test
    public void saveCart_13() throws Exception {
        Cart cart = null;
        this.mockMvc.perform(MockMvcRequestBuilders.post("/cart/create")
                .content(this.objectMapper.writeValueAsString(cart))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    /**
     * Create:DuyNP
     * Method: Test saveCart_18() all item ok
     */
    @Test
    public void saveCart_18() throws Exception {
        Cart cart = new Cart();
        cart.setId(98);
        cart.setCode("GH098");
        cart.setPurchaseDate("2022/01/01");
        cart.setTotalMoney(500.0);
        cart.setQuantity(10);
        cart.setCustomer(customerServicel.findById(1).get());
        cart.setEquipment(equipmentService.findById(1));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/cart/create")
                .content(this.objectMapper.writeValueAsString(cart))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }

}