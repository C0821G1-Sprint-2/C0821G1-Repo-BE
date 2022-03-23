package com.example.demo.entity.security;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "app_users")
//@SQLDelete(sql = "UPDATE app_users SET deleted = true WHERE id=?")
//@Where(clause = "deleted=false")

public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @NotBlank(message = " Tên đăng nhập không được để trống")
    private String username;
//    @NotBlank(message = " Mật khẩu không được để trống")
    private String password;
    private Boolean isEnabled;
    private String verificationCode;
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, targetEntity = Role.class)
//    @JoinTable(name = "app_users_roles",
//            joinColumns = @JoinColumn(name = "app_users_id"),
//            inverseJoinColumns = @JoinColumn(name = "roles_id"))
//    private Set<Role> roles;
        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = Roles.class)
    @JoinTable(name = "app_users_roles",
            joinColumns = @JoinColumn(name = "app_users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Roles> roles;

    private Boolean deleted = Boolean.FALSE;

    public AppUser() {
    }


    public AppUser(Integer id, String username, String password, Boolean isEnabled, String verificationCode, Set<Roles> roles, Boolean deleted) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isEnabled = isEnabled;
        this.verificationCode = verificationCode;
        this.roles = roles;
        this.deleted = deleted;
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
