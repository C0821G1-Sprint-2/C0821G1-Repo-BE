//package com.example.demo.test_case;
//
//import com.example.demo.dto.EquipmentDTO;
//import com.example.demo.entity.equipment.EquipmentType;
//import com.example.demo.entity.equipment.Supplier;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CreateEquipment {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void createStatus_13() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode("VT-001");
//        equipmentDTO.setName("Thuốc");
//        equipmentDTO.setPrice("10000");
//        equipmentDTO.setExpired("10/10/2020");
//        equipmentDTO.setImage("image");
//        equipmentDTO.setStatus(null);
//
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(1);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(1);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createCode_13() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode(null);
//        equipmentDTO.setName("Thuốc");
//        equipmentDTO.setPrice("10000");
//        equipmentDTO.setExpired("10/10/2020");
//        equipmentDTO.setImage("image");
//        equipmentDTO.setStatus("1");
//        equipmentDTO.setDeleteFlag(false);
//
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(1);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(1);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createName_13() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode("VT-001");
//        equipmentDTO.setName("Thuốc");
//        equipmentDTO.setPrice("10000");
//        equipmentDTO.setExpired("10/10/2020");
//        equipmentDTO.setImage("image");
//        equipmentDTO.setStatus("1");
//        equipmentDTO.setDeleteFlag(false);
//
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(1);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(1);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createPrice_13() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode("VT-001");
//        equipmentDTO.setName("Thuốc");
//        equipmentDTO.setPrice(null);
//        equipmentDTO.setExpired("10/10/2020");
//        equipmentDTO.setImage("image");
//        equipmentDTO.setStatus("1");
//        equipmentDTO.setDeleteFlag(false);
//
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(1);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(1);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    @Test
//    public void createExpired_13() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode("VT-001");
//        equipmentDTO.setName("Thuốc");
//        equipmentDTO.setPrice("1000");
//        equipmentDTO.setExpired(null);
//        equipmentDTO.setImage("image");
//        equipmentDTO.setStatus("1");
//        equipmentDTO.setDeleteFlag(false);
//
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(1);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(1);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    @Test
//    public void createImage_13() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode("VT-001");
//        equipmentDTO.setName("Thuốc");
//        equipmentDTO.setPrice("1000");
//        equipmentDTO.setExpired("10/10/2020");
//        equipmentDTO.setImage(null);
//        equipmentDTO.setStatus("1");
//        equipmentDTO.setDeleteFlag(false);
//
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(1);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(1);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createType_13() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode("VT-001");
//        equipmentDTO.setName("Thuốc");
//        equipmentDTO.setPrice("1000");
//        equipmentDTO.setExpired("10/10/2020");
//        equipmentDTO.setImage("image");
//        equipmentDTO.setStatus("1");
//        equipmentDTO.setDeleteFlag(false);
//
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(null);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(1);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createSupplier_13() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode("VT-001");
//        equipmentDTO.setName("Thuốc");
//        equipmentDTO.setPrice("1000");
//        equipmentDTO.setExpired("10/10/2020");
//        equipmentDTO.setImage("image");
//        equipmentDTO.setStatus("1");
//        equipmentDTO.setDeleteFlag(false);
//
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(1);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(null);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    @Test
//    public void createCode_14() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode("");
//        equipmentDTO.setName("Thuốc");
//        equipmentDTO.setPrice("1000");
//        equipmentDTO.setExpired(null);
//        equipmentDTO.setImage("image");
//        equipmentDTO.setStatus("1");
//        equipmentDTO.setDeleteFlag(false);
//
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(1);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(1);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createName_14() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode("VT-001");
//        equipmentDTO.setName("");
//        equipmentDTO.setPrice("1000");
//        equipmentDTO.setExpired("10/10/2020");
//        equipmentDTO.setImage("image");
//        equipmentDTO.setStatus("1");
//        equipmentDTO.setDeleteFlag(false);
//
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(1);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(1);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createPrice_14() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode("VT-001");
//        equipmentDTO.setName("Thuốc");
//        equipmentDTO.setPrice("");
//        equipmentDTO.setExpired("10/10/2020");
//        equipmentDTO.setImage("image");
//        equipmentDTO.setStatus("1");
//        equipmentDTO.setDeleteFlag(false);
//
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(1);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(1);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createExpired_14() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode("VT-001");
//        equipmentDTO.setName("Thuốc");
//        equipmentDTO.setPrice("1000");
//        equipmentDTO.setExpired("");
//        equipmentDTO.setImage("image");
//        equipmentDTO.setStatus("1");
//        equipmentDTO.setDeleteFlag(false);
//
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(null);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(1);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createImage_14() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode("");
//        equipmentDTO.setName("Thuốc");
//        equipmentDTO.setPrice("1000");
//        equipmentDTO.setExpired("10/10/2020");
//        equipmentDTO.setImage("");
//        equipmentDTO.setStatus("1");
//        equipmentDTO.setDeleteFlag(false);
//
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(1);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(null);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStatus_14() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode("VT-001");
//        equipmentDTO.setName("");
//        equipmentDTO.setPrice("sdsdsd");
//        equipmentDTO.setExpired("10/10/2020");
//        equipmentDTO.setImage("image");
//        equipmentDTO.setStatus("");
//        equipmentDTO.setDeleteFlag(false);
//
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(1);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(1);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createPrice_15() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode("VT-001");
//        equipmentDTO.setName("Thuốc");
//        equipmentDTO.setPrice("sdsdsd");
//        equipmentDTO.setExpired("10/10/2020");
//        equipmentDTO.setImage("image");
//        equipmentDTO.setStatus("1");
//        equipmentDTO.setDeleteFlag(false);
//
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(1);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(1);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void create_18() throws Exception {
//
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setId(1);
//        equipmentDTO.setCode("VT-001");
//        equipmentDTO.setName("Thuốc");
//        equipmentDTO.setPrice("10000");
//        equipmentDTO.setExpired("10/10/2020");
//        equipmentDTO.setImage("image");
//        equipmentDTO.setStatus("1");
//        equipmentDTO.setDeleteFlag(false);
//        EquipmentType equipmentType = new EquipmentType();
//        equipmentType.setId(1);
//        equipmentDTO.setEquipmentType(equipmentType);
//
//        Supplier supplier = new Supplier();
//        supplier.setId(1);
//        equipmentDTO.setSupplier(supplier);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/equipment/add")
//                        .content(this.objectMapper.writeValueAsString(equipmentDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}
