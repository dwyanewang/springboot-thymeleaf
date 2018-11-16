package com.dwyanewang.dao.test1;

import com.dwyanewang.entity.Users;
import com.dwyanewang.enums.UserSexEnums;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class User1MapperTest {
    @Resource
    private User1Mapper user1Mapper;

    @Test
    public void testInsert() throws Exception {
        user1Mapper.insert(new Users("aa","a123456", UserSexEnums.MAN));
        user1Mapper.insert(new Users("bb","a1234sd56", UserSexEnums.WOMAN));
        user1Mapper.insert(new Users("cc","a12aaaa56", UserSexEnums.MAN));
        Assert.assertEquals(3,user1Mapper.getAll().size());
    }

    @Test
    public void testQuery() throws  Exception {
        List<Users> users = user1Mapper.getAll();
        if (users == null || users.size() == 0) {
            System.out.println("is null");
        } else {
            Assert.assertEquals(3,users.size());
        }
    }
}