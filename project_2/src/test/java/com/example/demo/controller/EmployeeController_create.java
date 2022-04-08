package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.employee.EmployeePosition;
import com.example.demo.entity.security.AppUser;
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
public class EmployeeController_create {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createEmployee_employeeCode_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode(null);
        employeeDTO.setName("Đức Phiên");
        employeeDTO.setDateOfBirth("04/03/1993");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("Hải chau");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setEmployeePosition(employeeDTO.getEmployeePosition());
        employeeDTO.setImage("image1");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_employeeCode_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode("");
        employeeDTO.setName("Đức Phiên");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("Hải châu");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setImage("image1");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_employeeName_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode("NV-1234");
        employeeDTO.setName(null);
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("Hai chau");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setImage("image1");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_employeeName_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode("Nv-1234");
        employeeDTO.setName("");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("Hải châu");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setImage("image1");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_employeePhone_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode("Nv-1234");
        employeeDTO.setName("Đức Phiên");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("Hai chau");
        employeeDTO.setPhone(null);
        employeeDTO.setImage("image1");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_employeePhone_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode("Nv-1234");
        employeeDTO.setName("Đức Phiên");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("Hai chau");
        employeeDTO.setPhone("");
        employeeDTO.setImage("image1");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_employeeImage_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode("Nv-1234");
        employeeDTO.setName("Đưc phiên");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("Hai chau");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setImage("");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_employeeImage_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode("Nv-1234");
        employeeDTO.setName("Duc phien");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("Hai chau");
        employeeDTO.setPhone("012312");
        employeeDTO.setImage("");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

}
