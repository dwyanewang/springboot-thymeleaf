package com.dwyanewang.dao;

import com.dwyanewang.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from users")
    List<Users> findAll();
}
