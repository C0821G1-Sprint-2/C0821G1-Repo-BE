package com.example.demo.entity.employee;

import com.example.demo.entity.security.AppUser;

import javax.persistence.*;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String phone;
    private String image;
    private Boolean deleteFlag;

    @ManyToOne
    @JoinColumn(name = "employee_position_id", nullable = false)
    private EmployeePosition employeePosition;

    @OneToOne(targetEntity = AppUser.class, cascade = {CascadeType.PERSIST})
    private AppUser appUser;

    public Employee() {
    }

    public Employee(Integer id, String code, String name, String dateOfBirth, String gender, String address, String phone, String image, Boolean deleteFlag, EmployeePosition employeePosition, AppUser appUser) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.image = image;
        this.deleteFlag = deleteFlag;
        this.employeePosition = employeePosition;
        this.appUser = appUser;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

}
