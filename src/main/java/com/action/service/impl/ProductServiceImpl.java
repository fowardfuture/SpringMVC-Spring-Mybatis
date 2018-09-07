package com.action.service.impl;

import com.action.dao.ProductDao;
import com.action.dto.Product;
import com.action.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public ArrayList<Product> findby_hotproduct() {
        return productDao.findby_hotproduct();
    }

    @Override
    public ArrayList<Product> findby_newproduct() {
        return productDao.findby_newproduct();
    }

    @Override
    public Product findby_productid(Integer pid) {
        return productDao.findby_productid(pid);
    }

    @Override
    public ArrayList<Product> findby_categoryproduct(Map<String,Object> parm ) {
        return productDao.findby_categoryproduct( parm);
    }

    @Override
    public int findby_categoryproductNum( Map<String,Object> parm) {
        return productDao.findby_categoryproductNum(parm);
    }
}
