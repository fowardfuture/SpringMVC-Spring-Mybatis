import com.action.dto.Product;
import com.action.dto.Second_Menu;
import com.action.service.ProductService;
import com.action.until.PageModel;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Producttest {
    @Autowired
    private ProductService productService;

    @Test
    public void getproductpictur()
    {

       Map parm=new HashMap();
        Second_Menu second_menu=new Second_Menu();
        second_menu.setCid(1);
       parm.put("Second_Menu",second_menu);
        PageModel pageModel=new PageModel();
        pageModel.setIndexpage(1);
        pageModel.setTotaldatas(36);
        parm.put("PageModel",pageModel);

            ArrayList<Product> list=productService.findby_categoryproduct(parm);
            System.out.print(list.size());
            for (Product product:list)
            {
                System.out.print("HEHEHE");
                System.out.print(product.getPname()+product.getPdesc());
            }




    }
    @Test
    public void getmenudataNum()
    {
//        System.out.print(productService.findby_categoryproductNum());
    }
}
