package org.csu.mypetstore;

import org.csu.mypetstore.domain.*;
import org.csu.mypetstore.persistence.AccountMapper;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.AdminService;
import org.csu.mypetstore.service.CatelogService;
import org.csu.mypetstore.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@MapperScan("org.csu.mypetstore.persistence")
class MypetstoreApplicationTests {


    @Autowired
    AdminService adminService;
    @Autowired
    CatelogService catelogService;
    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {
    }

    @Test
    void ServiceTest(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(8);
        Date currentTime_2 = formatter.parse(dateString, pos);
        Order order = new Order(3, "es", currentTime_2, "Changsha", "Beijing", "USA", "China", "sef", "sef", "@sef", "@fs3f", "England", "123", "Chenchou", "123", "fesf", new BigDecimal(3), "ert", "yui", "xcv", "sef", "sefs", "sef", "3s", "sef", "sef");
        orderService.insertOrder(order);

    }

}
