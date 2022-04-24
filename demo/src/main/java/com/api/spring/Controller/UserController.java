package com.api.spring.Controller;

import com.api.spring.Service.UserService;
import com.api.spring.VO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService us;

    @Autowired
    private PasswordEncoder passwd;

    @GetMapping("/user/select")
    public List<User> select() {

        return us.select();
    }

    @GetMapping("/user/delete")
    public boolean delete() {

        return us.delete(1L);
    }

    @GetMapping("/user/insert")
    public boolean insert(@RequestBody User user) {

        return us.insert(user);
    }

    @PostMapping("/user/login")
    public boolean login(@RequestBody User user) {

        return false;
    }

}
