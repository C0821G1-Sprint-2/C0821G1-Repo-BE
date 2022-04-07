package com.example.demo.dto;

import com.example.demo.entity.equipment.EquipmentType;
import com.example.demo.entity.equipment.Supplier;

import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EquipmentDTO {
    private Integer id;
    @NotNull
    private String code;
    @NotNull
    private String name;
    @NotNull
//    @Pattern(regexp = "^[\\d]{4,9}$", message = "Số tiền phải nhập đúng định dạng")
    private String price;
    @NotNull
    private String expired;
    private String status;
    private Boolean deleteFlag;
    @NotNull
    private String image;
    @NotNull
    private EquipmentType equipmentType;
    @NotNull
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

    @Override
    public String toString() {
        return "EquipmentDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", expired='" + expired + '\'' +
                ", status='" + status + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", image='" + image + '\'' +
                ", equipmentType=" + equipmentType +
                ", supplier=" + supplier +
                '}';
    }
}
