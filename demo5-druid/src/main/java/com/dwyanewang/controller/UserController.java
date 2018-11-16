package com.dwyanewang.controller;

import com.dwyanewang.dao.UserMapper;
import com.dwyanewang.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getUsers")
    public List<Users> getUsers(){
        return userMapper.getAll();
    }

    @GetMapping("/getUser")
    public Users getUser(long id) {
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
