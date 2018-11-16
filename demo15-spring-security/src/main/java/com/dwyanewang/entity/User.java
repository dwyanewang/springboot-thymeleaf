package com.dwyanewang.entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {

  private long uId;
  private String uUsername;
  private String uPassword;
  private List<Roles> roles;


  public long getUId() {
    return uId;
  }

  public void setUId(long uId) {
    this.uId = uId;
  }


  public String getUUsername() {
    return uUsername;
  }

  public void setUUsername(String uUsername) {
    this.uUsername = uUsername;
  }


  public String getUPassword() {
    return uPassword;
  }

  public void setUPassword(String uPassword) {
    this.uPassword = uPassword;
  }

  public List<Roles> getRoles() {
    return roles;
  }

  public void setRoles(List<Roles> roles) {
    this.roles = roles;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    List<Roles> roles = getRoles();
    for (Roles role : roles) {
      grantedAuthorities.add(new SimpleGrantedAuthority(role.getFlag()));
    }
    return grantedAuthorities;
  }

  @Override
  public String getPassword() {
    return uPassword;
  }

  @Override
  public String getUsername() {
    return uUsername;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
