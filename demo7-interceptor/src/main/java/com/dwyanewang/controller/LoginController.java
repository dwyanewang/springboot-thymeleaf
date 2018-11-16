package com.dwyanewang.controller;

import com.dwyanewang.dao.UserMapper;
import com.dwyanewang.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class LoginController {
    private final UserMapper userMapper;

    @Autowired
    public LoginController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        //登录成功
        boolean flag = true;
        String result = "登录成功";
        Users u = userMapper.getUserByName(username);
        //用户不存在
        if (u == null) {
            flag = false;
            result = "用户不存在，登录失败";
        }
        //密码错误
        else if (!u.getPassWord().equals(password)) {
            flag = false;
            result = "用户密码不相符，登录失败";
        }
        //登录成功
        if (flag) {
            request.getSession().setAttribute("_session_user",u);
        }
        return result;
    }
}
