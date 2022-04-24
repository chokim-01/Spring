package com.api.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {


    @RequestMapping("/index")
    public String index(HttpServletRequest request) {

        return "index.html";
    }
    @RequestMapping("/user/signup")
    public String signup(HttpServletRequest request) {

        return "signup.html";
    }
    @RequestMapping("/user/signin")
    public String signin(HttpServletRequest request) {

        return "signin.html";
    }

}
