package org.scau.mall.web.security.pojo;

import java.util.Collection;
import java.util.Collections;

import org.scau.mall.service.pojo.PmsUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
* @author hyy
* @ClassName JwtUserService.java
* @Description TODO 该类封装登录用户相关信息，例如用户名，密码，权限集合等，需要实现UserDetails 接口，
* @createTime 2021年08月03日
*/
public class JwtUser implements UserDetails {
   private Integer id;
   private String username;
   private String password;
   private Collection<? extends GrantedAuthority> authorities;
   public JwtUser() {
   }
   // 写一个能直接使用user创建jwtUser的构造器
   public JwtUser(PmsUser user) {
       id = user.getId();
       username = user.getUsername();
       password = user.getPassword();
       authorities = Collections.singleton(new SimpleGrantedAuthority("all"));
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
       return authorities;
   }

   @Override
   public String getPassword() {
       return password;
   }

   @Override
   public String getUsername() {
       return username;
   }

   @Override
   public boolean isAccountNonExpired() {
       return false;
   }

   @Override
   public boolean isAccountNonLocked() {
       return false;
   }

   @Override
   public boolean isCredentialsNonExpired() {
       return false;
   }

   @Override
   public boolean isEnabled() {
       return false;
   }

   @Override
   public String toString() {
       return "JwtUserService{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", authorities=" + authorities +
               '}';
   }
}
