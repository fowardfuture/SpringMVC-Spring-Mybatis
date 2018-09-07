package com.action.controller;

import com.action.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(Model model)
    {
        User user=new User(9,"ss","ss","ss","ss","ss",2,"1");
        model.addAttribute("user",user);
        return  "test";
    }
}
