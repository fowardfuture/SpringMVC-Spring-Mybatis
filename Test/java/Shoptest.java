import com.action.dao.ShopDao;
import com.action.dto.*;
import com.action.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Shoptest {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopDao shopDao;
    @Test
    public void testaddshopcart()
    {
        Map<String,Object> map=new HashMap<String, Object>();
        User user=new User();
        user.setUid(8);
        Partshop_carts partshop_carts=new Partshop_carts();
        partshop_carts.setPid(10);
        Shop_Cart shop_cart=new Shop_Cart();
        shop_cart.setPcount(5);
        map.put("User",user);
        map.put("Partshop_carts",partshop_carts);
        map.put("Shop_Cart",shop_cart);
        shopService.add_shopcart(map);

    }
    @Test
    public void selectshopcarts()
    {
        User user=new User();
        user.setUid(8);
        Map<String,Object> parm=new HashMap<String,Object>();
        parm.put("User",user);
        ArrayList<Shop_Cart> data= shopService.selectshopcart(parm);

        for (Shop_Cart shop_cart: data)
        {

           System.out.print(shop_cart.getUser().getUsername() +shop_cart.getPcount()+shop_cart.getPartshop_carts().getPname()+"\n");

        }
    }
    @Test
    public void deletpartproduct()
    {
        User user=new User();
        user.setUid(8);
       Partshop_carts partshop_carts=new Partshop_carts();
       partshop_carts.setPid(2);
       Map<String,Object> parm=new HashMap<>();
       parm.put("User",user);
       parm.put("Partshop_carts",partshop_carts);
       shopService.deletpartproduct(parm);
    }
    @Test
    public  void getoid()
    {
        OrderUsermsg orderUsermsg=new OrderUsermsg();
        orderUsermsg.setAddr("东门");
        Timestamp timestamp=new Timestamp(new Date().getTime());
        orderUsermsg.setDate(timestamp);
        orderUsermsg.setPhone("17815910510");
        orderUsermsg.setTotal(500);
        orderUsermsg.setState(1);
        orderUsermsg.setName("肖");
        orderUsermsg.setUid(7);
        shopService.getoid(orderUsermsg);
        System.out.print(orderUsermsg.getOid());
    }
 @Test
    public void saveorder()
 {
     OrderUsermsg orderUsermsg=new OrderUsermsg();
     orderUsermsg.setAddr("东门");
     Timestamp timestamp=new Timestamp(new Date().getTime());
     orderUsermsg.setDate(timestamp);
     orderUsermsg.setPhone("17815910510");
     orderUsermsg.setTotal(500);
     orderUsermsg.setState(1);
     orderUsermsg.setName("肖");
     orderUsermsg.setUid(8);
     shopService.getoid(orderUsermsg);


     User user=new User();
     user.setUid(8);
     Map<String,Object> parm=new HashMap<String,Object>();
     parm.put("User",user);
     ArrayList<Shop_Cart> data= shopService.selectshopcart(parm);
     parm.put("OrderUsermsg",orderUsermsg);
     parm.put("Shop_Cartlist",data);
     shopDao.checkorder(parm);
 }
}
