package com.action.dao;

import com.action.dao.Provider.ProductProvider;
import com.action.dto.Product;
import com.action.dto.Second_Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.ArrayList;
import java.util.Map;

public interface ProductDao {
    @SelectProvider(type = ProductProvider.class,method = "findby_hotproduct")
    ArrayList<Product> findby_hotproduct();
    @SelectProvider(type = ProductProvider.class,method = "findby_newproduct")
    ArrayList<Product> findby_newproduct();
    @Select("select * from product where pid=#{pid}")
    Product findby_productid(@Param("pid") Integer pid);
    @SelectProvider(type = ProductProvider.class,method = "findby_categoryproduct")
    ArrayList<Product> findby_categoryproduct(Map<String,Object > parm);
    @SelectProvider(type = ProductProvider.class,method = "findby_categoryproductNum")
    int findby_categoryproductNum( Map<String,Object> parm);

}
