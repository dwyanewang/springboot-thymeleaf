package com.dwyanewang.service;

import com.dwyanewang.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> getAll();

    Users getOne(Long id);

    void insert(Users user);

    void update(Users user);

    void delete(Long id);
}
