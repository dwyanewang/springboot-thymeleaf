package com.dwyanewang.dao;

import com.dwyanewang.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from t_user")
    @Results({
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "username", column = "USERNAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "phoneNum", column = "PHONE_NUM")
    })
    List<User> list();

    @SelectProvider(type = UserSqlProvider.class, method = "listByUsername")
    List<User> listByUsername(String name);

    @Select("select * from t_user where USERNAME like CONCAT(\"%\",#{username},\"%\")   and PASSWORD like CONCAT(\"%\",#{password},\"%\")")
    List<User> getUsers(@Param("username") String username, @Param("password") String password);

    @SelectProvider(type = UserSqlProvider.class, method = "getBadUser")
    List<User> getBadUser(String username, String password);

}
