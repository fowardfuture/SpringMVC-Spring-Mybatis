import com.action.dto.Second_Menu;
import com.action.service.NavigaTion_barService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class NavigaTion {
    @Autowired
    private NavigaTion_barService navigaTion_barService;
    @Test
    public void secondmenu()
    {
        ArrayList<Second_Menu> data=navigaTion_barService.getsecondmenudate();
        for (Second_Menu second_menu:data)
        {
            System.out.print(second_menu.getCname()+"and"+second_menu.getCsname());
        }
    }
}
