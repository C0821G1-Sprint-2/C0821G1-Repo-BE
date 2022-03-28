package com.example.demo.dto;

import com.example.demo.entity.equipment.EquipmentType;
import com.example.demo.entity.equipment.Supplier;

import javax.validation.Validator;

public class EquipmentDTO {
    private Integer id;
    private String code;
    private String name;
    private String price;
    private String expired;
    private String status;
    private Boolean deleteFlag;
    private String image;
    private EquipmentType equipmentType;
    private Supplier supplier;

    public EquipmentDTO() {
    }

    public EquipmentDTO(Integer id, String code, String name, String price, String expired, String status, Boolean deleteFlag, String image, EquipmentType equipmentType, Supplier supplier) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.expired = expired;
        this.status = status;
        this.deleteFlag = deleteFlag;
        this.image = image;
        this.equipmentType = equipmentType;
        this.supplier = supplier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
