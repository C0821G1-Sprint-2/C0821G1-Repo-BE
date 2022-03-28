package com.example.demo.service.account.impl;
import com.example.demo.entity.security.AppUser;
import com.example.demo.entity.security.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// BaoNHG
public class MyUserDetailsImpl implements UserDetails {
//    Transient đóng vai trò quan trọng trong bảo mật, bạn có thể sử dụng nó để chắc rằng không lưu các nội dung
//    nhạy cảm xuống file, database hoặc chuyển chúng đến một nơi khác.
//Mặc định Spring Security sử dụng một đối tượng UserDetails để chứa toàn bộ thông tin về người dùng. Vì vậy,
//    chúng ta cần tạo ra một class mới giúp chuyển các thông tin của User thành UserDetails
//
    private transient AppUser appUser;

    public MyUserDetailsImpl(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Roles> roles = this.appUser.getRoles();
        for (Roles role: roles) {
                grantedAuthorities.add( new SimpleGrantedAuthority(role.getName()));
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.appUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.appUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.appUser.getEnabled();
    }
}
