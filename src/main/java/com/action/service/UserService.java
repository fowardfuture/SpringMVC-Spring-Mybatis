package com.action.service;

import com.action.dto.User;

public interface UserService {
    public User log(String password);
    boolean checkusername(String usrname);
    public void register(String username,String password,String name,String email,String phone,String addr);
}
