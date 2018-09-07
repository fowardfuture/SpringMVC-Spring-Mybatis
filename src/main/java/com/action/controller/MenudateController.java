package com.action.controller;

import com.action.dto.NavigaTion_Bar;
import com.action.dto.Second_Menu;
import com.action.service.NavigaTion_barService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MenudateController {
    @Autowired
    private NavigaTion_barService navigaTion_barService;
    //获取导航栏数据
    @RequestMapping("/getmenudate")
    @ResponseBody
    public String getmenudate(HttpServletResponse response, HttpServletRequest request)
    {
      ArrayList<NavigaTion_Bar> list=navigaTion_barService.getmenu();
       return JSONObject.toJSON(list).toString();

    }
    //获取二级目录数据
    @RequestMapping("/getsecondmenudate")
    @ResponseBody
    public String getsecondmenu()
    {
        List<Second_Menu> menudate=new ArrayList<Second_Menu>();
        try {
            menudate=navigaTion_barService.getsecondmenudate();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return JSONObject.toJSON(menudate).toString();
    }
}
