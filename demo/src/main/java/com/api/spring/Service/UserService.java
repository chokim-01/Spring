package com.api.spring.Service;

import com.api.spring.Interface.UserRepository;
import com.api.spring.VO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> select() {
        return userRepository.findAll();
    }

    public boolean insert(User user) {
        System.out.println("123");

        if(userRepository.existsByEmail(user.getEmail()))
            return false;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
