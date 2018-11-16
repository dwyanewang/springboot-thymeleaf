package com.dwyanewang;

import com.dwyanewang.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class LoggerConfigure implements WebMvcConfigurer {

    @Bean
    public LoggerInterceptor loggerInterceptor(){
        return new LoggerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggerInterceptor()).addPathPatterns("/**");
    }
}
