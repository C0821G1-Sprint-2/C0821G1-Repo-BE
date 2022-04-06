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
public class EmployeeController_deleteEmployee {
        @Autowired
    private MockMvc mockMvc;

//     [id] = null
    @Test
    public void deleteEmployee_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/employee/delete/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
        // [id] = rỗng
    @Test
    public void deleteEmployee_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/employee/delete/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    // [id] = không tồn tại
    @Test
    public void deleteEmployee_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/employee/delete/{id}","NV-000"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    // [id] =  tồn tại trong database
    @Test
    public void deleteEmployee_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/employee/delete/{id}","1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
