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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_editEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //VyLTT - edit successfully
    @Test
    public void editEmployee_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/:?username=hung"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.employee_id").value(2))
                .andExpect(jsonPath("$.app_user_id").value("2"))
                .andExpect(jsonPath("$.employee_name").value("hung"))
                .andExpect(jsonPath("$.employee_date_of_birth").value("1992-10-10"))
                .andExpect(jsonPath("$.employee_address").value("dn"))
                .andExpect(jsonPath("$.employee_email").value("hjj@gmail.com"))
                .andExpect(jsonPath("$.employee_gender").value(""));
    }

    //VyLTT - name is empty
    @Test
    public void editEmployee_employeeName_10() throws Exception {
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

    //VyLTT - date of birth is empty
    @Test
    public void editEmployee_dateOfBirth_11() throws Exception {
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

    //VyLTT - address is empty
    @Test
    public void editEmployee_address_12() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode(null);
        employeeDTO.setName("Le duc phien");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("0");
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

    //VyLTT - phone is empty
    @Test
    public void editEmployee_phone_13() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode(null);
        employeeDTO.setName("Le duc phien");
        employeeDTO.setDateOfBirth("04/03/1999");
        employeeDTO.setGender("1");
        employeeDTO.setAddress("Hải chau");
        employeeDTO.setPhone("");
        employeeDTO.setImage("image1.png");
        employeeDTO.setDeleteFlag(null);

        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setId(1);
        employeeDTO.setEmployeePosition(employeePosition);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/edit")
                .content(this.objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    //VyLTT - can not load image
    @Test
    public void editEmployee_image_14() throws Exception {
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

    //VyLTT - gender is empty
    @Test
    public void editEmployee_gender_14() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode(null);
        employeeDTO.setName("Le duc phien");
        employeeDTO.setDateOfBirth(null);
        employeeDTO.setGender("");
        employeeDTO.setAddress("Hải châu");
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
