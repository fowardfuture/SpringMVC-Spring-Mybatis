package com.action.controller;

import com.action.until.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PictureController {
    @RequestMapping("/picture")
    @ResponseBody
    public void picture(HttpServletResponse response, HttpServletRequest request) throws ServletException,IOException
    {
        CaptchaUtil.outputCaptcha(request,response);
    }
}
