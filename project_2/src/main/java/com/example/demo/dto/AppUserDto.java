package com.example.demo.dto;

import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.security.Roles;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class AppUserDto {
    private Integer id;
    @NotBlank(message = " Tên đăng nhập không được để trống")

    private String username;
    @NotBlank(message = " Mật khẩu không được để trống")

    private String password;
    private Boolean isEnabled;
    private String verificationCode;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = Roles.class)
    @JoinTable(name = "app_users_roles",
            joinColumns = @JoinColumn(name = "app_users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Roles> roles;

//    @OneToOne(targetEntity = Employee.class, cascade = {CascadeType.PERSIST})
//    private Employee employee;


    private Boolean deleted = Boolean.FALSE;

    public AppUserDto(Integer id, String username, String password, Boolean isEnabled, String verificationCode, Set<Roles> roles, Boolean deleted) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isEnabled = isEnabled;
        this.verificationCode = verificationCode;
        this.roles = roles;
        this.deleted = deleted;
    }

    public AppUserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
