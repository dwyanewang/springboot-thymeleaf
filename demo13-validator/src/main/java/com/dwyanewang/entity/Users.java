package com.dwyanewang.entity;


import com.dwyanewang.vilidator.FlagValidator;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Users {

    @NotBlank
    @Length(min = 2, max = 10)
    private String userName;
    @Min(value = 1)
    @Max(value = 35)
    private int age;
    @NotBlank
    @Email
    private String email;
    @FlagValidator(values = "1,2,3")
    private String flag;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
