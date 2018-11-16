package com.dwyanewang.controller;

import com.dwyanewang.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
public class IndexController {
    private final MessageSource messageSource;

    @Autowired
    public IndexController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/validator")
    public String validator(@Valid Users user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder msg = new StringBuilder();
            //获取错误字段集合
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            //获取本地locale,zh_CN
            Locale currentLocale = LocaleContextHolder.getLocale();
            //遍历错误字段获取错误消息
            for (FieldError fieldError : fieldErrors) {
                //获取错误信息
                String errorMsg = messageSource.getMessage(fieldError, currentLocale);
                //添加到错误消息集合内
                msg.append(fieldError.getField()).append(":").append(errorMsg).append(",");
            }
            return msg.toString();
        }
        return "验证通过，" + "名称： " + user.getUserName() + "  年龄：" + user.getAge() + "  邮箱地址：" + user.getEmail();
    }
}
