package com.dwyanewang.service.impl;

import com.dwyanewang.dao.UserMapper;
import com.dwyanewang.entity.Users;
import com.dwyanewang.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<Users> findAll() {
        return userMapper.findAll();
    }
}
