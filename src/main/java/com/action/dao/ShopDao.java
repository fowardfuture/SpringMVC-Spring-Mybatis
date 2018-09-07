package com.action.dao;

import com.action.dao.Provider.ShopDaoProvider;
import com.action.dto.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.ArrayList;
import java.util.Map;

public interface ShopDao {
       //添加购物车
       @SelectProvider(type = ShopDaoProvider.class ,method = "ispid_excist")
       Integer ispid_excist(Map<String,Object> parm);
       @UpdateProvider(type = ShopDaoProvider.class,method = "update_shopcount")
       void update_shopcount(Map<String,Object> parm);
       @InsertProvider(type = ShopDaoProvider.class,method = "add_shopmsg")
       void add_shopmsg(Map<String,Object> parm);

       //查询购物车
       @SelectProvider(type = ShopDaoProvider.class ,method = "selectshopcart")
       @Results({



               @Result(column = "uid",property = "user",
               one =@One(select = "com.action.dao.ShopDao.selectuser",fetchType = FetchType.EAGER)),
               @Result(column = "pid" ,property = "partshop_carts",
                one = @One(select = "com.action.dao.ShopDao.selectpartshopcart",fetchType = FetchType.EAGER)),
               @Result(column = "pcount",property = "pcount")

       } )
       ArrayList<Shop_Cart> selectshopcart(Map<String,Object> parm);
       @Select("select pid, pname,shop_price as shopprice, image as pimage from product  where  product.pid=#{pid}")
       Partshop_carts selectpartshopcart(Integer pid);
       @Select("select * from user where uid=#{uid}")
       User selectuser(Integer uid);


       //删除部分购物车
       @DeleteProvider(type =ShopDaoProvider.class,method = "deletpartproduct")
       void deletpartproduct(Map<String ,Object> parm);


       //添加收货信息到订单
       @Insert("insert into orders (total,ordertime,state,name,phone,addr,uid )values ( #{total},#{date},#{state},#{name},#{phone},#{addr},#{uid})")
        @Options(useGeneratedKeys = true,keyProperty = "oid")
       int getoid(OrderUsermsg orderUsermsg);

       //添加订单货物信息
       @InsertProvider(type =ShopDaoProvider.class ,method = "checkorder")
       void  checkorder(Map<String,Object> parm);

       //添加订单成功后删除该用户下的购物车
       @Delete("delete * from shop-carts where uid = #{uid}")
       void  deleteshop_carts(@Param("uid") Integer uid);
}
