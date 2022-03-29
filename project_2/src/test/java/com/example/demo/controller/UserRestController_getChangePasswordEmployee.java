package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
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
public class UserRestController_getChangePasswordEmployee {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    //VyLTT - fill null in the blanks
    @Test
    public void authenticateUser_13() throws Exception {
        UserDTO changePasswordDTO = new UserDTO();
        changePasswordDTO.setCurrentPassword(null);
        changePasswordDTO.setNewPassword(null);
        changePasswordDTO.setConfirmPassword(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/changePassword")
                        .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    //VyLTT - no fill in the blanks
    @Test
    public void authenticateUser_14() throws Exception {
        UserDTO changePasswordDTO = new UserDTO();
        changePasswordDTO.setCurrentPassword("");
        changePasswordDTO.setNewPassword("");
        changePasswordDTO.setConfirmPassword("");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/changePassword")
                        .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //VyLTT - fill wrong confirm password in the blanks
    @Test
    public void authenticateUser_15() throws Exception {
        UserDTO changePasswordDTO = new UserDTO();
        changePasswordDTO.setCurrentPassword("123");
        changePasswordDTO.setNewPassword("456");
        changePasswordDTO.setConfirmPassword("333");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/changePassword")
                        .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //VyLTT- change password successfully
    @Test
    public void authenticateUser_16() throws Exception {
        UserDTO changePasswordDTO = new UserDTO();
        changePasswordDTO.setCurrentPassword("234");
        changePasswordDTO.setNewPassword("123");
        changePasswordDTO.setConfirmPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/changePassword")
                        .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
