package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.employee.EmployeePosition;
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
public class EmployeeController_edit {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void editEmployee_employeeCode_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode(null);
        employeeDTO.setName("Le duc phien");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("Hải chau");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setImage("image1.png");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/edit")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    public void editEmployee_employeeCode_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode(null);
        employeeDTO.setName("");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("Hải chau");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setImage("image1.png");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/edit")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    public void editEmployee_employeeName_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode(null);
        employeeDTO.setName("Le duc phien");
        employeeDTO.setDateOfBirth("");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("Hải chau");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setImage("image1.png");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/edit")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_employeeGender_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode(null);
        employeeDTO.setName("Le duc phien");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("0");
        employeeDTO.setAddress("Hải chau");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setImage("image1.png");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/edit")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_employeeGender_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode(null);
        employeeDTO.setName("Le duc phien");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("0");
        employeeDTO.setAddress("Hải chau");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setImage("image1.png");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/edit")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_employeeAddress_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode(null);
        employeeDTO.setName("Le duc phien");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setImage("image1.png");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/edit")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_employeeAddress_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode(null);
        employeeDTO.setName("Le duc phien");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("1234");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setImage("image1.png");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/edit")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_employeeDeleteFlag_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode(null);
        employeeDTO.setName("Le duc phien");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setImage("image1.png");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/edit")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_employeeDeleteFlag_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode(null);
        employeeDTO.setName("Le duc phien");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setImage("image1.png");
        employeeDTO.setDeleteFlag(false);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/edit")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_employeeDateOfBirth_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode(null);
        employeeDTO.setName("Le duc phien");
        employeeDTO.setDateOfBirth("");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setImage("image1.png");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/edit")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_employeeDateOfBirth_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode(null);
        employeeDTO.setName("Le duc phien");
        employeeDTO.setDateOfBirth(null);
        employeeDTO.setGender("1");
        employeeDTO.setAddress("");
        employeeDTO.setPhone("0903157020");
        employeeDTO.setImage("image1.png");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/edit")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
}
