package com.action.dao.Provider;

import com.action.dto.OrderUsermsg;
import com.action.dto.Shop_Cart;
import com.action.dto.User;
import org.apache.ibatis.jdbc.SQL;

import java.util.ArrayList;
import java.util.Map;

public class ShopDaoProvider {
    //判断是否需要加入购物车的商品是否已近存在
    public String ispid_excist(Map<String,Object> parm)
    {
        String sql=new SQL(){{
        SELECT("pid");
        FROM("shop_carts");
        WHERE("pid=#{Partshop_carts.pid} and uid=#{User.uid}");
        }}.toString();
        return sql;
    }
    //购物车已存在该商品数量加上现在的购买数量
    public String update_shopcount(Map<String,Object> parm)
    {
        String sql=new SQL(){{
            UPDATE("shop_carts");
            SET("pcount=pcount+#{Shop_Cart.pcount}");
            WHERE("uid=#{User.uid} and pid=#{Partshop_carts.pid}");
        }}.toString();
        return sql;
    }
    //购物车不存在该商品插入该商品信息以及数量
    public String add_shopmsg(Map<String,Object> parm){
        String sql=new SQL(){{
            INSERT_INTO("shop_carts");
            VALUES("pid,pcount,uid","#{Partshop_carts.pid},#{Shop_Cart.pcount},#{User.uid}");
        }}.toString();
        return sql;
    }
    //查询用户购物车下的商品
    public String selectshopcart(Map<String,Object> parm)
    {
        String sql=new SQL(){{
         SELECT("*");

         FROM("shop_carts");
         WHERE("uid=#{User.uid}");
        }}.toString();
        return sql;
    }
    //删除购物车下的某一个商品
    public String deletpartproduct(Map<String,Object> parm)
    {
        String sql=new SQL(){{
            DELETE_FROM("shop_carts");
            WHERE("pid=#{Partshop_carts.pid} and uid=#{User.uid}");
        }}.toString();
        return sql;
    }

   // 提交订单
    public String checkorder(final Map<String, Object> parm)//提供uid count subtotal pid oid
    {


       StringBuilder sql=new StringBuilder();
        sql.append("INSERT INTO orderitem (count, subtotal, pid, oid) values ");
        OrderUsermsg orderUsermsg=(OrderUsermsg)parm.get("OrderUsermsg");
        ArrayList<Shop_Cart> list=(ArrayList<Shop_Cart>)parm.get("Shop_Cartlist") ;
        for (Shop_Cart shop_cart : list)
        {
            sql.append("("+shop_cart.getPcount()+","+shop_cart.getPartshop_carts().getShopprice()*shop_cart.getPcount()+","+shop_cart.getPartshop_carts().getPid()+","
            +orderUsermsg.getOid()+")"+",");
        }
         sql.delete(sql.length()-1,sql.length());
        String newsql=new SQL(){{}}.toString();
        newsql+=sql.toString();
       return newsql;
    }

}
