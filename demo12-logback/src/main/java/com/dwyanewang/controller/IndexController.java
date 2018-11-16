package com.dwyanewang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
    @GetMapping("/index")
    public String index(){
        LOGGER.error("记录ERROR错误日志");
        LOGGER.info("访问了index方法");
        LOGGER.debug("记录DEBUG日志");
        return "index";
    }
}
