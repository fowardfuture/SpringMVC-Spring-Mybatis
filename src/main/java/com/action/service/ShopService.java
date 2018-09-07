package com.action.service;

import com.action.dto.OrderUsermsg;
import com.action.dto.Shop_Cart;

import java.util.ArrayList;
import java.util.Map;

public interface ShopService {
    public void add_shopcart(Map<String,Object> parm);
    ArrayList<Shop_Cart> selectshopcart(Map<String,Object> parm) ;
    public  void  deletpartproduct(Map<String,Object> parm);
    public void getoid(OrderUsermsg orderUsermsg);
    public void checkorder(Map<String ,Object> parm);
    public void deleteshop_carts(Integer uid);
}
