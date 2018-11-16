package com.dwyanewang.controller;

import com.dwyanewang.entity.Users;
import com.dwyanewang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    public List<Users> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/getUser")
    public Users getUser(long id) {
        return userService.getOne(id);
    }

    @PostMapping("/add")
    public void save(Users user){
        userService.insert(user);
    }

    @PutMapping("/update")
    public void update(Users user) {
        userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id){
        userService.delete(id);
    }
}
