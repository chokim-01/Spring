package com.api.spring.Service.Security;

import com.api.spring.Interface.UserRepository;
import com.api.spring.VO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

// DB에서 찾아서 인증 객체를 만들기
public class UserDetailCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userrepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userrepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User Not found Exception"));
        // user details 형태로 변환
        return new CustomUserDetails(user);

    }
}
