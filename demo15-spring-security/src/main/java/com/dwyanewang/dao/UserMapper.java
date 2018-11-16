package com.dwyanewang.dao;

import com.dwyanewang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where u_username = #{username}")
    User getUserByName(String username);
}
