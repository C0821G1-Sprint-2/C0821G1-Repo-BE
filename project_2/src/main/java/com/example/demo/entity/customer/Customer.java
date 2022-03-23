package com.example.demo.entity.customer;

import com.example.demo.entity.order.OrderEquipment;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    private String email;

    private String phone;

    private String address;

    private Boolean deleteFlag;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private List<OrderEquipment> orderEquipments;
    public Customer() {
    }

    public List<OrderEquipment> getOrderEquipments() {
        return orderEquipments;
    }

    public void setOrderEquipments(List<OrderEquipment> orderEquipments) {
        this.orderEquipments = orderEquipments;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
