package com.dwyanewang.demo02mybatisannotation.controller;

import com.dwyanewang.demo02mybatisannotation.dao.UserMapper;
import com.dwyanewang.demo02mybatisannotation.entity.Users;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
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
