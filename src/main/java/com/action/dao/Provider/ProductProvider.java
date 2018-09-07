package com.action.dao.Provider;


import com.action.dto.Second_Menu;
import com.action.until.PageModel;
import com.sun.crypto.provider.DESCipher;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;


public class ProductProvider {
    public String findby_hotproduct()
    {
       String sql= new SQL(){{
           SELECT("*");

           FROM("product");
           WHERE("is_hot=1");
       }

    }.toString();
         sql+=" limit 0,10";
       return sql;
    }
    public String findby_newproduct()
    {
        String sql=new SQL(){{
            SELECT("*");
            FROM("product");
            ORDER_BY("pdate");
        }}.toString();
        sql+=" limit 0,20";
        return sql;
    }
   public String findby_categoryproduct(final Map<String,Object > parm)
   {
       String sql=new SQL(){{
           SELECT("pid,pname,market_price,shop_price,image,pdesc,is_hot");
           FROM("product");
           FROM("categorysecond");
           FROM("category");
           Second_Menu second_menu=(Second_Menu)parm.get("Second_Menu") ;
           if (null!=second_menu.getCid()) {
               WHERE("category.cid=#{Second_Menu.cid}");
           }
           else
           {
               WHERE("categorysecond.csid=#{Second_Menu.csid}");
           }
       }}.toString();
       sql+=" and category.cid=categorysecond.cid and product.csid=categorysecond.csid limit #{PageModel.firstLimit},#{PageModel.per_pagenum} ";

       return sql;
   }
   public String findby_categoryproductNum(final Map<String,Object> parm)
   {
       String sql=new SQL(){{
           SELECT("COUNT(*)");
           FROM("categorysecond");
           FROM("category");
           FROM("product");
           Second_Menu second_menu=(Second_Menu)parm.get("Second_Menu") ;
           if (null!=second_menu.getCid()) {
               WHERE("category.cid=#{Second_Menu.cid}");
           }
           else
           {
               WHERE("categorysecond.csid=#{Second_Menu.csid}");
           }
       }}.toString();
       sql+=" and category.cid=categorysecond.cid and product.csid=categorysecond.csid ";

       return sql;
   }


}
