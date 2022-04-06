package com.example.demo.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EquipmentRestController_findById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create:DuyNP
     * Method: Test find by id equipment id = null
     */
    @Test
    public void findById_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/equipment/find-by-id/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create:DuyNP
     * Method: Test find by id equipment id = rỗng ("")
     */
    @Test
    public void findById_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/equipment/find-by-id/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create:DuyNP
     * Method: Test find by id equipment does not exist in Database
     */
    @Test
    public void findById_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/equipment/find-by-id/{id}", 6))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create:DuyNP
     * Method: Test  find by id equipment exist in Database
     */
    @Test
    public void findById_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/equipment/find-by-id/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
