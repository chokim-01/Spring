package com.api.spring.Controller;

import com.api.spring.Service.UserService;
import com.api.spring.VO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService us;

    @GetMapping("/user/select")
    public List<User> select() {

        return us.select();
    }

    @GetMapping("/user/delete")
    public boolean delete() {

        return us.delete(1L);
    }

    @GetMapping("/user/insert")
    public boolean insert() {

        User user = User.builder().email("a@a").name("jaegon").password("1234").build();
        return us.insert(user);
    }
}
