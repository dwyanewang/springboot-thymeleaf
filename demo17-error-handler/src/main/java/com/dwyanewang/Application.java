package com.dwyanewang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void randomException() throws Exception {
        Exception[] exceptions = {
                new NullPointerException(),
                new ArrayIndexOutOfBoundsException(),
                new NumberFormatException(),
                new SQLException()
        };
        double probability = 0.75;
        if (Math.random() < probability) {
            throw exceptions[(int) (Math.random() * exceptions.length)];
        }

    }

    @GetMapping("/index")
    public List index() throws Exception {
        randomException();
        return Arrays.asList("正常用户数据1！", "正常用户数据2！ 请按F5刷新！！");
    }
}
