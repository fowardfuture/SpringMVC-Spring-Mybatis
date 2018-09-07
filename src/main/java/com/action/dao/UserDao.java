package com.action.dao;

import com.action.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
   @Select("select * from user where password =#{password}")
    User log(@Param("password") String password);
   @Select("select * from user where username=#{username}")
    User checkusername(@Param("username") String username);
   @Insert("insert into user (username,password,name,email,phone,addr,state) values (#{username},#{password},#{name},#{email},#{phone},#{addr},1)")
    void  register(@Param("username")String username ,@Param("password")String password,@Param("name")String name,@Param("email")String email,@Param("phone")String phone,@Param("addr")String addr);
}
