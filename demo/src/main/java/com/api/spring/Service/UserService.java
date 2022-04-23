package com.api.spring.Service;

import com.api.spring.Interface.UserRepository;
import com.api.spring.VO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> select() {
        return userRepository.findAll();
    }

    public boolean insert(User user) {
        try {
            userRepository.save(user);
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}
