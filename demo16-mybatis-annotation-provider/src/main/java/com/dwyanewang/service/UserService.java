package com.dwyanewang.service;

import com.dwyanewang.entity.User;

import java.util.List;

public interface UserService {
    List<User> list();
    List<User> listByUsername(String name);
    List<User> getUsers(String username, String password);
    List<User> getBadUser(String username, String password);

}
