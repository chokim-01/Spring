package com.api.spring.Service.Security;


import com.api.spring.VO.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// 스프링 시큐리티 형식으로 객체 변환

@Getter
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private User user;

    // 권한 설정
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한이 들어가는 리스트 loadUserByUsername에서 만든 유저의 형태를 변경

        List<GrantedAuthority> auth = new ArrayList<>();
        auth.add(new SimpleGrantedAuthority(user.getRole()));

        return auth;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
