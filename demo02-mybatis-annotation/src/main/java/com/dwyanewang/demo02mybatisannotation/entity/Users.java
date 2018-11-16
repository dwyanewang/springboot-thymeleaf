package com.dwyanewang.demo02mybatisannotation.entity;


import com.dwyanewang.demo02mybatisannotation.enums.UserSexEnum;

import java.io.Serializable;

public class Users implements Serializable {

  private static final long serialVersionUID = 6961030805865474546L;
  private long id;
  private String userName;
  private String passWord;
  private UserSexEnum userSex;
  private String nickName;

  public Users() {
  }

  public Users(String userName, String passWord, UserSexEnum userSex) {
    this.userName = userName;
    this.passWord = passWord;
    this.userSex = userSex;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  public UserSexEnum getUserSex() {
    return userSex;
  }

  public void setUserSex(UserSexEnum userSex) {
    this.userSex = userSex;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  @Override
  public String toString() {
    return "Users{" +
            "userName='" + userName + '\'' +
            ", passWord='" + passWord + '\'' +
            ", userSex='" + userSex + '\'' +
            '}';
  }
}
