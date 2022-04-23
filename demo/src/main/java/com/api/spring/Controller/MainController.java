package com.api.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class MainController {

    @RequestMapping("/main")
    public String main() {

        return "main page";
    }

    @RequestMapping("/error")
    @ResponseBody
    public String errorpage(){
        return "error page";
    }
}
