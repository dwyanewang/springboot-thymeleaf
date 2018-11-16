package com.dwyanewang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    @GetMapping("/test")
    public String test(){
        LOGGER.debug("记录了DEBUG日志");
        LOGGER.info("访问了test方法");
        LOGGER.error("记录了ERROR错误日志");
        return "test";
    }
}
