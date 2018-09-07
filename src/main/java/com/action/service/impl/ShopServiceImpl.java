package com.action.service.impl;

import com.action.dao.ShopDao;
import com.action.dto.OrderUsermsg;
import com.action.dto.Shop_Cart;
import com.action.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
@Service("ShopService")
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;
     //添加购物车
    @Override
    public void add_shopcart(Map<String, Object> parm) {
        if (null==shopDao.ispid_excist(parm))
        {
            shopDao.add_shopmsg(parm);
        }else {
            shopDao.update_shopcount(parm);
        }
    }
   //查询某用户下的购物车
    @Override
    public ArrayList<Shop_Cart> selectshopcart(Map<String, Object> parm) {
        return shopDao.selectshopcart(parm);
    }
   //删除部分购物车
    @Override
    public void deletpartproduct(Map<String, Object> parm) {
        shopDao.deletpartproduct(parm);
    }

    @Override
    public void getoid(OrderUsermsg orderUsermsg) {
        shopDao.getoid(orderUsermsg);
    }

    @Override
    public void checkorder(Map<String, Object> parm) {
        shopDao.checkorder(parm);
    }

    @Override
    public void deleteshop_carts(Integer uid) {
        shopDao.deleteshop_carts(uid);
    }
}
