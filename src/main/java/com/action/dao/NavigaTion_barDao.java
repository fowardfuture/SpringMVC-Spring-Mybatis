package com.action.dao;

import com.action.dao.Provider.NavigaTion_barProvider;
import com.action.dto.NavigaTion_Bar;
import com.action.dto.Second_Menu;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.ArrayList;

public interface NavigaTion_barDao {
    @Select("select * from category")
    ArrayList<NavigaTion_Bar> menu();
    @Select("select * from categorysecond")
    ArrayList<Second_Menu> frindby_secondmenudate();
    @SelectProvider(type = NavigaTion_barProvider.class,method = "getsecondmenudate")
    ArrayList<Second_Menu> getsecondmenudate();
}
