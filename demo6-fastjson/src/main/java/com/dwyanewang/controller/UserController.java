package com.dwyanewang.controller;

import com.dwyanewang.dao.UserMapper;
import com.dwyanewang.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/getUsers")
    public List<Users> getUsers(){
        return userMapper.getAll();
    }

    @GetMapping("/getUser/{id}")
    public Users getUser(@PathVariable("id") long id) {
        return userMapper.getOne(id);
    }

    @PostMapping("add")
    public void save(Users user){
        userMapper.insert(user);
    }

    @PutMapping("/update")
    public void update(Users user) {
        userMapper.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id){
        userMapper.delete(id);
    }
}
