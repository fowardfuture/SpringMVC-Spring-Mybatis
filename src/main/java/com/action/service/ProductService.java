package com.action.service;

import com.action.dto.Product;

import java.util.ArrayList;
import java.util.Map;

public interface ProductService {
   public ArrayList<Product> findby_hotproduct();
   public ArrayList<Product> findby_newproduct();
   public Product findby_productid(Integer pid);
   public ArrayList<Product> findby_categoryproduct(Map<String,Object> parm);
   int findby_categoryproductNum( Map<String,Object> parm);
}
