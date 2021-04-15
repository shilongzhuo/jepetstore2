package org.csu.mypetstore;

import org.csu.mypetstore.domain.*;
import org.csu.mypetstore.persistence.AccountMapper;
import org.csu.mypetstore.service.*;
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
    @Autowired
    InventoryService inventoryService;

    @Autowired
    AccountService accountService;
    @Autowired
    AccountMapper accountMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void ServiceTest(){

    }

}
