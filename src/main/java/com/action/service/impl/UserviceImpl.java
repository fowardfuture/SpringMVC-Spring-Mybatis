package com.action.service.impl;

import com.action.dao.UserDao;
import com.action.dto.User;
import com.action.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Uservice")
public class UserviceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User log(String password) {
        User user =new User();
        try {
             user =(User)userDao.log(password);

        }catch (Exception e)
        {

            e.printStackTrace();
        }
       return user;
    }

    @Override
    public boolean checkusername(String usrname) {
      try {
          User user=(User)userDao.checkusername(usrname);
          if (user==null)
              return false;
          else
              return true;
      }catch (Exception e)
      {
          e.printStackTrace();
      }
      return false;
    }

    @Override
    public void register(String username, String password, String name, String email, String phone, String addr) {
        userDao.register(username,password,name,email,phone,addr);
    }
}
