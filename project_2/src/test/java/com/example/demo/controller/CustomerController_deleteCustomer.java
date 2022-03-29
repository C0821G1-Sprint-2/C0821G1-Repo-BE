package com.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerController_deleteCustomer {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    //      DuongNT- customer detail - id = null
    @Test
    public void deleteCustomer_25() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/customer/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //      VyLTT- customer detail - id = ""
    @Test
    public void deleteCustomer_26() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/customer/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //      VyLTT- customer detail - id is not exist in DB
    @Test
    public void deleteCustomer_27() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/customer/delete/{id}", "21"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //      VyLTT- customer detail - id is exist in DB
    @Test
    public void deleteCustomer_28() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/customer/delete/{id}", "2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }
}
