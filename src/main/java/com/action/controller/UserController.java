package com.action.controller;

import com.action.dto.Activation_Code;
import com.action.dto.User;
import com.action.service.UserService;
import com.action.until.CaptchaUtil;
import com.action.until.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller

public class UserController {
    @Autowired
    private UserService userService;
   //登录
    @RequestMapping("/Login")
    @ResponseBody
    public String Login(String username, String password,String captcha, HttpSession session) {
        //先判断验证码是否正确
        String code = (String) session.getAttribute("randomString");
        if (!captcha.equalsIgnoreCase(code)) {
            return "codefalse";
        } else {
            //通过密码判断用户名或者邮箱是否正确
            User user = new User();
            try {
                user = userService.log(password);

            } catch (Exception e) {
                e.printStackTrace();
            }
            if (null==user) {
                return "false";
            } else {
                if (username.equals(user.getUsername()) || username.equals(user.getEmail())) {
                    System.out.print("success");
                    session.setAttribute("user",user);
                    return "success";

                } else {
                    System.out.print("false");
                    return "false";
                }
            }
        }
    }
    //验证用户名是否可用
    @RequestMapping("checkusername")
    @ResponseBody
    public String checkname(String username ,HttpServletResponse response,HttpServletRequest request ) {
        if ("" == username) {
            return "wrrong_username";
        } else {
            boolean isexcist = true;
            try {
                isexcist = userService.checkusername(username);

            } catch (Exception e) {
                e.printStackTrace();
            }
            if (isexcist == false) {
                return "notexcist";
            } else
                return "excist";
        }
    }
    //用户注册

    @RequestMapping("Register")
    @ResponseBody
    @Transactional
    public String Register(String picture_code,String code,User user,HttpServletRequest request,HttpServletResponse response,HttpSession session)
    {
        String code1=(String) session.getAttribute("randomString");//获得验证码对象
        String result=null;
        //验证验证码是否正确
        if (code1.equalsIgnoreCase(picture_code))
        {
            Activation_Code activation_code=(Activation_Code)session.getAttribute("Code");
          if (activation_code.getCode().equalsIgnoreCase(code)&& TimeUtil.cmptime(activation_code.getDate()))//验证激活码是否正确
          {
                   try {
                       userService.register(user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getPhone(),user.getAddr());
                       result= "success";
                   }catch (Exception e)
                   {
                       e.printStackTrace();
                       result= "false";
                   }

          }
          else
          {
             result= "worrong_activation_code";
          }
        }
        else
            {
                result= "wrrong_code";
            }

            return result;
    }

}
