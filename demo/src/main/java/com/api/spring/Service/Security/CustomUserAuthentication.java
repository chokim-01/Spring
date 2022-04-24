package com.api.spring.Service.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomUserAuthentication implements AuthenticationProvider {
    @Autowired
    private UserDetailCustomService userdetailservice;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String passwd = (String)authentication.getCredentials();
        UserDetails userDetails = userdetailservice.loadUserByUsername(email);
        if(passwordEncoder.matches(passwd,userDetails.getPassword()))
            return new UsernamePasswordAuthenticationToken(email,null,userDetails.getAuthorities());

        throw new BadCredentialsException("Authenticate Error");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
