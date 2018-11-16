package com.dwyanewang.vilidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class FlagValidatorClass implements ConstraintValidator<FlagValidator, Object> {
    //临时变量保存flag值列表
    private String values;

    //初始化values的值
    @Override
    public void initialize(FlagValidator constraintAnnotation) {
        //将注解内配置的值赋值给临时变量
        this.values = constraintAnnotation.values();
    }

    //实现验证
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        //分割定义的有效值
        String[] value_array = values.split(",");
        boolean isFlag = false;
        //遍历比对有效值
        for (String s : value_array) {
            //存在一致跳出循环，赋值isFlag=true
            if (s.equals(value)) {
                isFlag = true;
                break;
            }
        }
        //返回是否存在boolean
        return isFlag;
    }
}
