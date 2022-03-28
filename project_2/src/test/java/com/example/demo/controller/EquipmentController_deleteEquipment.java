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
public class EquipmentController_deleteEquipment {
    @Autowired
    private MockMvc mockMvc;
    // [id] = null
    @Test
    public void deleteEquipment_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/equipment/delete-equipment/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    // [id] = rỗng
    @Test
    public void deleteEquipment_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/equipment/delete-equipment/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
//    // [id] = không tồn tại
    @Test
    public void deleteEquipment_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/equipment/delete-equipment/{id}","19"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
//    // [id] =  tồn tại trong database
    @Test
    public void deleteEquipment_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/equipment/delete-equipment/{id}","2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
