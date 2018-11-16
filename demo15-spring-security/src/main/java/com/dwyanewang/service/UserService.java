package com.dwyanewang.service;

import com.dwyanewang.dao.UserMapper;
import com.dwyanewang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userMapper.getUserByName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("未查询到用户： " + userName + "信息！");
        }
        return user;
    }
}
