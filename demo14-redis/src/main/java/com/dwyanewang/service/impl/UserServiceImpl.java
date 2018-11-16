package com.dwyanewang.service.impl;

import com.dwyanewang.dao.UserMapper;
import com.dwyanewang.entity.Users;
import com.dwyanewang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Cacheable
    public List<Users> getAll() {
        return userMapper.getAll();
    }

    @Override
    public Users getOne(Long id) {
        return userMapper.getOne(id);
    }

    @Override
    public void insert(Users user) {
        userMapper.insert(user);
    }

    @Override
    public void update(Users user) {
        userMapper.update(user);
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);
    }
}
