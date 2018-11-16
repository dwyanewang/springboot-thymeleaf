package com.dwyanewang.controller;

import com.dwyanewang.entity.User;
import com.dwyanewang.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user/*")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("/list/{username}")
    public List<User> listByUserName(@PathVariable("username") String name) {
        return userService.listByUsername(name);
    }

    @GetMapping("/getUsers/{username}/{password}")
    public List<User> getUsers(@PathVariable("username") String username, @PathVariable("password") String password) {
        return userService.getUsers(username, password);
    }

    @GetMapping("/getBadUser/{username}/{password}")
    public List<User> getBadUser(@PathVariable("username") String username, @PathVariable("password") String password) {
        return userService.getBadUser(username,password);
    }
}


