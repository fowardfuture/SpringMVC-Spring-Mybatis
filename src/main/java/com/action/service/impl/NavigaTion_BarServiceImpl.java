package com.action.service.impl;

import com.action.dao.NavigaTion_barDao;
import com.action.dto.NavigaTion_Bar;
import com.action.dto.Second_Menu;
import com.action.service.NavigaTion_barService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service("NavigaTion_barService")
public class NavigaTion_BarServiceImpl implements NavigaTion_barService {
    @Autowired
    private NavigaTion_barDao navigaTion_barDao;

    @Override
    public ArrayList<NavigaTion_Bar> getmenu() {
        ArrayList<NavigaTion_Bar> menudate=navigaTion_barDao.menu();
        return menudate;
    }


    @Override
    public ArrayList<Second_Menu> getsecondmenudate() {
        return navigaTion_barDao.getsecondmenudate();
    }
}
