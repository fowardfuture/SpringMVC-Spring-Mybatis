package com.action.controller;

import com.action.dto.Product;
import com.action.dto.Second_Menu;
import com.action.service.ProductService;
import com.action.until.PageModel;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    //加载热门商品
    @RequestMapping("/findby_hotproduct")
    @ResponseBody
    public String findby_hotproduct()
    {
        List productdate=new ArrayList<Product>();
        try {
            productdate=productService.findby_hotproduct();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return JSONObject.toJSON(productdate).toString();
    }
    //加载最新商品
    @RequestMapping("findby_newproduct")
    @ResponseBody
    public String findby_newproduct()
    {
        List productdate=new ArrayList<Product>();
        try {
            productdate=productService.findby_newproduct();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return JSONObject.toJSON(productdate).toString();
    }
    //获取商品详细信息
    @RequestMapping("/findby_productid")
    public ModelAndView findby_detailproduct(Integer pid,ModelAndView mv)
    {
        try {
            Product productdate = productService.findby_productid(pid);
            mv.addObject("productdate", productdate);
            mv.setViewName("dividepage");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
            return mv;
    }
    //点击导航栏进入商品分类界面
    @RequestMapping("/secondmenucid")
    public ModelAndView secondmenucid(Integer cid,ModelAndView mv)
    {
        Second_Menu second_menu=new Second_Menu();
        second_menu.setCid(cid);
        mv.addObject("second_menu",second_menu);
        mv.setViewName("secondcategory");
        return mv;
    }
    //获取一级目录下的商品图片 名称 价格
    @RequestMapping("/getproduct_id")
    @ResponseBody
    @Transactional
    public String getproduct_cid(Integer cid,Integer pageindex,Integer csid)
    {
      List<Product> productdata=new ArrayList<Product>();
        try {
            Map parm=new HashMap();
            Second_Menu second_menu=new Second_Menu();
            second_menu.setCid(cid);
            second_menu.setCsid(csid);
            parm.put("Second_Menu",second_menu);
             int num=productService.findby_categoryproductNum(parm);//获取cid下有几条数据
            PageModel pageModel=new PageModel();
            pageModel.setIndexpage(pageindex);
            pageModel.setTotaldatas(num);
            parm.put("PageModel",pageModel);
            productdata=productService.findby_categoryproduct(parm);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return  JSONObject.toJSON(productdata).toString();
    }
    //获取页数
    @RequestMapping("/get_totalpages")
    @ResponseBody
    public String gettotalpage(Integer cid,Integer csid)
    {
        int num=0;
        try {
            Map<String,Object> parm=new HashMap<String, Object>();
            Second_Menu second_menu=new Second_Menu();
            second_menu.setCsid(csid);
            second_menu.setCid(cid);
            parm.put("Second_Menu",second_menu);
             num=productService.findby_categoryproductNum(parm);
        }catch (Exception e) {
            e.printStackTrace();
        }
        PageModel pageModel=new PageModel();
        pageModel.setTotaldatas(num);
        pageModel.getTotalpage();
        Integer totalpages=pageModel.getTotalpage();
        return JSONObject.toJSON(totalpages).toString();

    }


}
