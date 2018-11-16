package com.dwyanewang.dao.test1;

import com.dwyanewang.entity.Users;
import com.dwyanewang.enums.UserSexEnums;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface User1Mapper {
    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnums.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<Users> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnums.class),
            @Result(property = "nickName", column = "nick_name")
    })
    Users getOne(Long id);

    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(Users user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(Users user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);
}
