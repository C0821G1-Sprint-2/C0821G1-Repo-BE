package com.example.demo.controller;

import com.example.demo.dto.AppUserDto;
import com.example.demo.entity.security.Roles;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AppUserController_registerAccount {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void registerAccount_username_13() throws Exception{
        AppUserDto appUserDto=new AppUserDto();
        appUserDto.setUsername(null);
        appUserDto.setPassword("123");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/appuser/create/{code}","")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void registerAccount_username_14() throws Exception{
        AppUserDto appUserDto=new AppUserDto();
        appUserDto.setUsername("");
        appUserDto.setPassword("123");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/appuser/create/{code}","")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void registerAccount_password_13() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUsername("giabao");
        appUserDto.setPassword(null);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/appuser/create/{code}", "")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void registerAccount_password_14() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUsername("giabao");
        appUserDto.setPassword("");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/appuser/create/{code}", "")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void registerAccount_18() throws Exception {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setId(1);
        appUserDto.setUsername("giabao");
        appUserDto.setPassword("123");
        Set<Roles> roleList = new HashSet<>();
        Roles roles = new Roles();
        roles.setId(1);
        roleList.add(roles);
        appUserDto.setRoles(roleList);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/appuser/create/{code}", "null")
                        .content(this.objectMapper.writeValueAsString(appUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }


}
