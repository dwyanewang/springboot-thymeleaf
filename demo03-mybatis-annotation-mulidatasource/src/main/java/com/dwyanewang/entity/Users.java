package com.dwyanewang.entity;


import com.dwyanewang.enums.UserSexEnums;

import java.io.Serializable;

public class Users implements Serializable {

  private static final long serialVersionUID = 5069562165284200226L;
  private long id;
  private String userName;
  private String passWord;
  private UserSexEnums userSex;
  private String nickName;

  public Users() {
  }

  public Users(String userName, String passWord, UserSexEnums userSex) {
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


  public UserSexEnums getUserSex() {
    return userSex;
  }

  public void setUserSex(UserSexEnums userSex) {
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
            ", userSex=" + userSex +
            '}';
  }
}
