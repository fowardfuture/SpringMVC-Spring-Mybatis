package com.action.controller;

import com.action.dto.Activation_Code;
import com.action.until.MailUtil;
import com.action.until.TimeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MailController {
    @RequestMapping("/sendmail")
    public void sendmail(String Email, HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {   //通过验证码dto将生成的验证吗与生成的时间绑定在一起
        String code=MailUtil.getRandomString();
        MailUtil mailUtil=new MailUtil();
        TimeUtil timeUtil=new TimeUtil();
        String time=timeUtil.gettime();
        try {
            mailUtil.sendMail(Email,code);
            Activation_Code activation_code=new Activation_Code(code,time);
            session.setAttribute("Code",activation_code);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
