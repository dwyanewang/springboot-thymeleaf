package com.dwyanewang.dao.test2;

import com.dwyanewang.entity.Users;
import com.dwyanewang.enums.UserSexEnums;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@SpringBootTest
public class User2MapperTest {
    @Resource
    private User2Mapper user2Mapper;

    @Test
    public void testInsert() throws Exception {
        user2Mapper.insert(new Users("aa","a123456", UserSexEnums.MAN));
        user2Mapper.insert(new Users("bb","a1234sd56", UserSexEnums.WOMAN));
        user2Mapper.insert(new Users("bb","a12df3456", UserSexEnums.MAN));
        Assert.assertEquals(3,user2Mapper.getAll().size());
    }
}