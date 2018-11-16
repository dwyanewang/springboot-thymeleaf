package com.dwyanewang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class IndexController {
    /**
     * 初始化登录界面
     * @return String
     */
    @GetMapping("/login_view")
//    public ModelAndView login_view(){
//        ModelAndView view = new ModelAndView();
//        view.setViewName("login");
//        return view;
//    }
    public String login_view() {
        return "login";
    }

    @GetMapping("/index")
//    public ModelAndView index(){
//        ModelAndView view = new ModelAndView();
//        view.setViewName("index");
//        return view;
//    }
    public String index() {
        return "index";
    }
}
