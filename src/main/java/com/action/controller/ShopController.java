package com.action.controller;

import com.action.dto.*;
import com.action.service.ShopService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller

public class ShopController {
    @Autowired
    private ShopService shopService;
    //添加购物车
    @RequestMapping("/addshop_cart")
    public ModelAndView addshop_cart(ModelAndView mv,Integer pid,Integer pcount, HttpSession session)
    {
        User user=(User)session.getAttribute("user");//获取用户id
        Partshop_carts partshop_carts=new Partshop_carts();
        Shop_Cart shop_cart=new Shop_Cart();
        shop_cart.setPcount(pcount);
        partshop_carts.setPid(pid);
        Map<String ,Object> parm=new HashMap<String,Object>();
        parm.put("User",user);
        parm.put("Partshop_carts",partshop_carts);
        parm.put("Shop_Cart",shop_cart);
        try {
            shopService.add_shopcart(parm);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        mv.setViewName("shopping-carts");
        return mv;
    }
    //查询购物车
    @RequestMapping("/select_shopcart")
    @ResponseBody
    public String select_shopcart(HttpSession session)
    {
        User user=(User) session.getAttribute("user");
        Map<String,Object> parm=new HashMap<>();
        parm.put("User",user);
        ArrayList<Shop_Cart> data=new ArrayList<>();
        try {
           data= shopService.selectshopcart(parm);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return JSONObject.toJSON(data).toString();
    }
    //删除部分购物车数据并返回当前购物车数据
    @RequestMapping("/delete_partshopcart")
    @ResponseBody
    @Transactional
    public String delete_partshopcart(HttpSession session,Integer pid)
    {
        Map<String,Object> parm=new HashMap<String, Object>();
        User user=(User)session.getAttribute("user");
        Partshop_carts partshop_carts=new Partshop_carts();
        partshop_carts.setPid(pid);
        parm.put("User",user);
        parm.put("Partshop_carts",partshop_carts);
        ArrayList<Shop_Cart> data=new ArrayList<Shop_Cart>();
        try {
            shopService.deletpartproduct(parm);
            data=shopService.selectshopcart(parm);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return JSONObject.toJSON(data).toString();
    }
    //添加购物信息到订单
    @RequestMapping("/checkorder")
    @Transactional
    public String  saveorder(HttpSession session ,String addr,String phone,String name ,Integer total )
    {
        Map<String,Object> parm=new HashMap<String,Object>();
        User user=(User)session.getAttribute("user");
        parm.put("User",user);
        OrderUsermsg orderUsermsg=new OrderUsermsg();
        Timestamp timestamp=new Timestamp(new Date().getTime());
        orderUsermsg.setDate(timestamp);
        orderUsermsg.setState(1);
        orderUsermsg.setName(name);
        orderUsermsg.setAddr(addr);
        orderUsermsg.setPhone(phone);
        orderUsermsg.setTotal(total);
        orderUsermsg.setUid(user.getUid());
        try {
            shopService.getoid(orderUsermsg);
            ArrayList<Shop_Cart> data= shopService.selectshopcart(parm);
            parm.put("OrderUsermsg",orderUsermsg);
            parm.put("Shop_Cartlist",data);
            shopService.checkorder(parm);
            shopService.deleteshop_carts(user.getUid());
        }catch (Exception e)
        {
            e.printStackTrace();
        }

         return "test";
    }
}
