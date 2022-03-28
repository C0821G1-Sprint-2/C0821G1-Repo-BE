package com.example.demo.dto;

import com.example.demo.entity.cart.Address;
import com.example.demo.entity.customer.Customer;


public class CustomerDTO {

    private Integer id;
    private String name;
    private String phone;
    private String email;
    private Address address;
    private Iterable<Customer> customers;

    public CustomerDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Iterable<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Iterable<Customer> customers) {
        this.customers = customers;
    }
}
