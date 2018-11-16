package com.dwyanewang.demo02mybatisannotation.dao;

import com.dwyanewang.demo02mybatisannotation.entity.Users;
import com.dwyanewang.demo02mybatisannotation.enums.UserSexEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception{
        userMapper.insert(new Users("aa","a123456", UserSexEnum.MAN));
        userMapper.insert(new Users("bb","b123456", UserSexEnum.WOMAN));
        userMapper.insert(new Users("cc","c123456",UserSexEnum.WOMAN));
        Assert.assertEquals(3,userMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception{
        List<Users> users = userMapper.getAll();
        System.out.println(users.toString());
    }

    @Test
    public void testUpdate() throws  Exception{
        Users user = userMapper.getOne((long) 31);
        System.out.println(user.toString());
        user.setNickName("dwyanewang");
        userMapper.update(user);
        Assert.assertEquals("dwyanewang", userMapper.getOne((long) 31).getNickName());
    }
}