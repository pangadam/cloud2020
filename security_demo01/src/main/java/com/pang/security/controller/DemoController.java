package com.pang.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello Security";
    }

    @GetMapping("/login")
    public String login(String username, String password){
        return "success";
    }

}
