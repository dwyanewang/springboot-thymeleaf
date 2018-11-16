package com.dwyanewang.demo01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    @GetMapping("/api/{id}")
    public ModelAndView index(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView();
        if (id == 1) {
            mv.setViewName("index");
            mv.addObject("hello", 1234546754);
        }
        if (id == 2) {
            mv.setViewName("index1");
            mv.addObject("hello1", "asasfasf");
            mv.addObject("hello2", "555555");
        }
        return mv;
    }
}
