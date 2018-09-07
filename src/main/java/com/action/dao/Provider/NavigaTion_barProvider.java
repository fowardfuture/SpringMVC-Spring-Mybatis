package com.action.dao.Provider;

import org.apache.ibatis.jdbc.SQL;

public class NavigaTion_barProvider {
     public String getsecondmenudate()
     {
         String sql=new SQL(){{
             SELECT("category.cname,category.cid,categorysecond.csname,categorysecond.csid");
             FROM("category");
             FROM("categorysecond");
         }}.toString();
         sql+=" where category.cid=categorysecond.cid";
         return sql;
     }
}
