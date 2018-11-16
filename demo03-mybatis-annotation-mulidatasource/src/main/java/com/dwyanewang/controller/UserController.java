package com.dwyanewang.controller;

import com.dwyanewang.dao.test1.User1Mapper;
import com.dwyanewang.dao.test2.User2Mapper;
import com.dwyanewang.entity.Users;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private User1Mapper user1Mapper;
    @Resource
    private User2Mapper user2Mapper;

    @GetMapping("/getUsers")
    public List<Users> getUsers() {
        return user1Mapper.getAll();
    }

    @GetMapping("/getUser/{id}")
    public Users getUser(@PathVariable("id") long id) {
        return user2Mapper.getOne(id);
    }

    @GetMapping("/getUser")
    public Users getUserByID(){
        Users user = user1Mapper.getOne((long) 28);
        return user2Mapper.getOne(user.getId());
    }



    @PostMapping("/add")
    public void save(Users user) {
        user2Mapper.insert(user);
    }

    @PutMapping("/update")
    public void update(Users user) {
        user2Mapper.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        user1Mapper.delete(id);
    }
}
