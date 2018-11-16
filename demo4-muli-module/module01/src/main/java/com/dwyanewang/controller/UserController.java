package com.dwyanewang.controller;

import com.dwyanewang.Test;
import com.dwyanewang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    private final Test test;

    @Autowired
    public UserController(Test test) {
        this.test = test;
    }

    @GetMapping("/api")
    public String index(){
        return userService.findAll().toString();
    }

    @GetMapping("/test")
    public String test(){
        return test.hello();
    }
}
