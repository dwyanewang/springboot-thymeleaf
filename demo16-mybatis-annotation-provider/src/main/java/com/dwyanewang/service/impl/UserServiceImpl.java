package com.dwyanewang.service.impl;

import com.dwyanewang.dao.UserMapper;
import com.dwyanewang.entity.User;
import com.dwyanewang.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public List<User> listByUsername(String name) {
        return userMapper.listByUsername(name);
    }

    @Override
    public List<User> getUsers(String username, String password) {
        return userMapper.getUsers(username, password);
    }

    @Override
    public List<User> getBadUser(String username, String password) {
        return userMapper.getBadUser(username, password);
    }
}
