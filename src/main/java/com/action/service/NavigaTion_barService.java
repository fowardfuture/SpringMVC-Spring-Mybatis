package com.action.service;

import com.action.dto.NavigaTion_Bar;
import com.action.dto.Second_Menu;

import java.util.ArrayList;

public interface NavigaTion_barService {
    ArrayList<NavigaTion_Bar> getmenu();
    ArrayList<Second_Menu> getsecondmenudate();
}
