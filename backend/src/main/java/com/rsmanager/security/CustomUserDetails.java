package com.rsmanager.security;

import com.rsmanager.model.BackendUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;

public class CustomUserDetails implements UserDetails {

    private BackendUser user;

    public CustomUserDetails(BackendUser user) {
        this.user = user;
    }

    public BackendUser getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 返回用户角色作为权限
        return Collections.singletonList((GrantedAuthority) () -> "ROLE_" + user.getRole().getName());
    }

    @Override
    public String getPassword() {
        return user.getPassword(); // 假设密码已加密存储
    }

    @Override
    public String getUsername() {
        return user.getUsername(); // 假设用户名是唯一的
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 根据需要实现
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 根据需要实现
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 根据需要实现
    }

    @Override
    public boolean isEnabled() {
        return true; // 根据需要实现，或根据 user 的状态字段
    }
}
